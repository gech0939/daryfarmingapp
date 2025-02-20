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
import com.yourpackagename.dairyapp.models.Sale;
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
public final class SaleDao_Impl implements SaleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Sale> __insertionAdapterOfSale;

  private final EntityDeletionOrUpdateAdapter<Sale> __updateAdapterOfSale;

  public SaleDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSale = new EntityInsertionAdapter<Sale>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `sales` (`id`,`product`,`amount`,`date`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Sale entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getProduct() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getProduct());
        }
        statement.bindDouble(3, entity.getAmount());
        if (entity.getDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDate());
        }
      }
    };
    this.__updateAdapterOfSale = new EntityDeletionOrUpdateAdapter<Sale>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `sales` SET `id` = ?,`product` = ?,`amount` = ?,`date` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Sale entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getProduct() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getProduct());
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
  public void insertSale(final Sale sale) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSale.insert(sale);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSale(final Sale sale) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSale.handle(sale);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Sale> getAllSales() {
    final String _sql = "SELECT * FROM sales";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "product");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<Sale> _result = new ArrayList<Sale>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Sale _item;
        final String _tmpProduct;
        if (_cursor.isNull(_cursorIndexOfProduct)) {
          _tmpProduct = null;
        } else {
          _tmpProduct = _cursor.getString(_cursorIndexOfProduct);
        }
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new Sale(_tmpProduct,_tmpAmount,_tmpDate);
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
