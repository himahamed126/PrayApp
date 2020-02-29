package com.example.prayapp.data.local.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Prays.class, version = 1)
abstract class PrayRoomDb extends RoomDatabase {

    private static PrayRoomDb instance;

    abstract PrayDao prayDao();

    //Singlton
    static synchronized PrayRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, PrayRoomDb.class, "pray_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private PrayDao mPrayDao;
        PopulateDataAsyncTask(PrayRoomDb db) {
            mPrayDao = db.prayDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mPrayDao.insert(new Prays("20/2/2020", true, true, true, true, true, 5));
            mPrayDao.insert(new Prays("21/2/2020", true, true, false, true, true, 5));
            mPrayDao.insert(new Prays("20/2/2020", true, true, true, true, true, 5));

            return null;
        }
    }
}
