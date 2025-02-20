package com.yourpackagename.dairyapp.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.yourpackagename.dairyapp.models.HealthRecord;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HealthRecordDao_Impl implements HealthRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HealthRecord> __insertionAdapterOfHealthRecord;

  private final EntityDeletionOrUpdateAdapter<HealthRecord> __updateAdapterOfHealthRecord;

  public HealthRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHealthRecord = new EntityInsertionAdapter<HealthRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `health_records` (`id`,`recordDate`,`description`,`vetName`,`treatments`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final HealthRecord entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getRecordDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getRecordDate());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getVetName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getVetName());
        }
        if (entity.getTreatments() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTreatments());
        }
      }
    };
    this.__updateAdapterOfHealthRecord = new EntityDeletionOrUpdateAdapter<HealthRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `health_records` SET `id` = ?,`recordDate` = ?,`description` = ?,`vetName` = ?,`treatments` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final HealthRecord entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getRecordDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getRecordDate());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getVetName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getVetName());
        }
        if (entity.getTreatments() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTreatments());
        }
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public void insertHealthRecord(final HealthRecord healthRecord) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHealthRecord.insert(healthRecord);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateHealthRecord(final HealthRecord healthRecord) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfHealthRecord.handle(healthRecord);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<HealthRecord> getAllHealthRecords() {
    final String _sql = "SELECT * FROM health_records";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "recordDate");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfVetName = CursorUtil.getColumnIndexOrThrow(_cursor, "vetName");
      final int _cursorIndexOfTreatments = CursorUtil.getColumnIndexOrThrow(_cursor, "treatments");
      final List<HealthRecord> _result = new ArrayList<HealthRecord>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final HealthRecord _item;
        final String _tmpRecordDate;
        if (_cursor.isNull(_cursorIndexOfRecordDate)) {
          _tmpRecordDate = null;
        } else {
          _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpVetName;
        if (_cursor.isNull(_cursorIndexOfVetName)) {
          _tmpVetName = null;
        } else {
          _tmpVetName = _cursor.getString(_cursorIndexOfVetName);
        }
        final String _tmpTreatments;
        if (_cursor.isNull(_cursorIndexOfTreatments)) {
          _tmpTreatments = null;
        } else {
          _tmpTreatments = _cursor.getString(_cursorIndexOfTreatments);
        }
        _item = new HealthRecord(_tmpRecordDate,_tmpDescription,_tmpVetName,_tmpTreatments);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
