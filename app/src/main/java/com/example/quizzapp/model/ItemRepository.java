package com.example.quizzapp.model;

import android.os.AsyncTask;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ItemRepository implements ItemDao {

    private final ItemDao mItemDao;

    public ItemRepository(ItemDao itemDao) {
        mItemDao = itemDao;
    }

    @Override
    public List<Item> getAllItems() {
        try {
            return new GetAllItemsTask().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Item> getAllItemsSortedAZ() {
        try {
            return new GetAllItemsSortedAZTask().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Item> getAllItemsSortedZA() {
        try {
            return new GetAllItemsSortedZATask().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Item item) {
        new InsertItemTask(item).execute();
    }

    @Override
    public void update(Item item) {
        new UpdateItemTask(item).execute();
    }

    @Override
    public void delete(Item item) {
        new DeleteItemTask(item).execute();
    }

    @Override
    public Item getRandomItem() {
        try {
            return new getRandomItemTask().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private class GetAllItemsTask extends AsyncTask<Void, Void, List<Item>> {

        @Override
        protected List<Item> doInBackground(Void... voids) {
            return mItemDao.getAllItems();
        }
    }

    private class GetAllItemsSortedAZTask extends AsyncTask<Void, Void, List<Item>> {

        @Override
        protected List<Item> doInBackground(Void... voids) {
            mItemDao.getAllItemsSortedAZ();
            return null;
        }
    }

    private class GetAllItemsSortedZATask extends AsyncTask<Void, Void, List<Item>> {

        @Override
        protected List<Item> doInBackground(Void... voids) {
            mItemDao.getAllItemsSortedZA();
            return null;
        }
    }

    private class InsertItemTask extends AsyncTask<Void, Void, Void> {

        private final Item mItem;

        public InsertItemTask(Item item) {
            mItem = item;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mItemDao.insert(mItem);
            return null;
        }
    }

    private class UpdateItemTask extends AsyncTask<Void, Void, Void> {

        private final Item mItem;

        public UpdateItemTask(Item item) {
            mItem = item;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mItemDao.update(mItem);
            return null;
        }
    }

    private class DeleteItemTask extends AsyncTask<Void, Void, Void> {

        private final Item mItem;

        public DeleteItemTask(Item item) {
            mItem = item;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mItemDao.delete(mItem);
            return null;
        }
    }

    private class getRandomItemTask extends AsyncTask<Void, Void, Item> {

        @Override
        protected Item doInBackground(Void... voids) {
            return mItemDao.getRandomItem();
        }
    }
}
