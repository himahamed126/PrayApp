package com.example.prayapp.data.local.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

class PrayRepository {

    private PrayDao mPrayDao;
    private LiveData<List<Prays>> getAllPrays;

    PrayRepository(Application app) {
        PrayRoomDb db = PrayRoomDb.getInstance(app);
        mPrayDao = db.prayDao();
        getAllPrays = mPrayDao.getAllPrays();
    }

    void insert(Prays prays) {
        new InsertAsyncTask(mPrayDao).execute(prays);
    }

    void update(Prays prays) {
        new UpdateAsyncTask(mPrayDao).execute(prays);
    }

    void delete(Prays prays) {
        new DeleteAsyncTask(mPrayDao).execute(prays);
    }

    void deleteAllPrays() {
        new DeleteAllPraysAsyncTask(mPrayDao).execute();
    }

    LiveData<List<Prays>> getAllPrays() {
        return getAllPrays;
    }

    private static class InsertAsyncTask extends AsyncTask<Prays, Void, Void> {
        PrayDao mPrayDao;

        InsertAsyncTask(PrayDao prayDao) {
            mPrayDao = prayDao;
        }

        @Override
        protected Void doInBackground(Prays... prays) {
            mPrayDao.insert(prays[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Prays, Void, Void> {
        PrayDao mPrayDao;

        UpdateAsyncTask(PrayDao prayDao) {
            mPrayDao = prayDao;
        }

        @Override
        protected Void doInBackground(Prays... prays) {
            mPrayDao.update(prays[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Prays, Void, Void> {
        PrayDao mPrayDao;

        DeleteAsyncTask(PrayDao prayDao) {
            mPrayDao = prayDao;
        }

        @Override
        protected Void doInBackground(Prays... prays) {
            mPrayDao.delete(prays[0]);
            return null;
        }
    }

    private static class DeleteAllPraysAsyncTask extends AsyncTask<Void, Void, Void> {
        PrayDao mPrayDao;

        DeleteAllPraysAsyncTask(PrayDao prayDao) {
            mPrayDao = prayDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mPrayDao.deleteAllPrays();
            return null;
        }
    }
}
