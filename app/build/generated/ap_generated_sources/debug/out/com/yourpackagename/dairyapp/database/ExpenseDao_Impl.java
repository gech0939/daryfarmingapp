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
import com.yourpackagename.dairyapp.models.Expense;
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
public final class ExpenseDao_Impl implements ExpenseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Expense> __insertionAdapterOfExpense;

  private final EntityDeletionOrUpdateAdapter<Expense> __updateAdapterOfExpense;

  public ExpenseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExpense = new EntityInsertionAdapter<Expense>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `expenses` (`id`,`description`,`amount`,`date`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Expense entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDescription() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescription());
        }
        statement.bindDouble(3, entity.getAmount());
        if (entity.getDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDate());
        }
      }
    };
    this.__updateAdapterOfExpense = new EntityDeletionOrUpdateAdapter<Expense>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `expenses` SET `id` = ?,`description` = ?,`amount` = ?,`date` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Expense entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDescription() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescription());
        }
        statement.bindDouble(3, entity.getAmount());
        if (entity.getDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDate());
        }
        statement.bindLong(5, entity.getId());
      }
    };
  }

  @Override
  public void insertExpense(final Expense expense) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfExpense.insert(expense);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateExpense(final Expense expense) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfExpense.handle(expense);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Expense> getAllExpenses() {
    final String _sql = "SELECT * FROM expenses";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<Expense> _result = new ArrayList<Expense>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Expense _item;
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new Expense(_tmpDescription,_tmpAmount,_tmpDate);
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
