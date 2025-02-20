package com.yourpackagename.dairyapp.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DairyDatabase_Impl extends DairyDatabase {
  private volatile AnimalDao _animalDao;

  private volatile ExpenseDao _expenseDao;

  private volatile SaleDao _saleDao;

  private volatile HealthRecordDao _healthRecordDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `animals` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `breed` TEXT, `dob` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `expenses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `description` TEXT, `amount` REAL NOT NULL, `date` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sales` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `product` TEXT, `amount` REAL NOT NULL, `date` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `health_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recordDate` TEXT, `description` TEXT, `vetName` TEXT, `treatments` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd8d787a20864b670377bc4af5151f1ad')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `animals`");
        db.execSQL("DROP TABLE IF EXISTS `expenses`");
        db.execSQL("DROP TABLE IF EXISTS `sales`");
        db.execSQL("DROP TABLE IF EXISTS `health_records`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsAnimals = new HashMap<String, TableInfo.Column>(4);
        _columnsAnimals.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnimals.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnimals.put("breed", new TableInfo.Column("breed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnimals.put("dob", new TableInfo.Column("dob", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAnimals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAnimals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAnimals = new TableInfo("animals", _columnsAnimals, _foreignKeysAnimals, _indicesAnimals);
        final TableInfo _existingAnimals = TableInfo.read(db, "animals");
        if (!_infoAnimals.equals(_existingAnimals)) {
          return new RoomOpenHelper.ValidationResult(false, "animals(com.yourpackagename.dairyapp.models.Animal).\n"
                  + " Expected:\n" + _infoAnimals + "\n"
                  + " Found:\n" + _existingAnimals);
        }
        final HashMap<String, TableInfo.Column> _columnsExpenses = new HashMap<String, TableInfo.Column>(4);
        _columnsExpenses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExpenses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExpenses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExpenses = new TableInfo("expenses", _columnsExpenses, _foreignKeysExpenses, _indicesExpenses);
        final TableInfo _existingExpenses = TableInfo.read(db, "expenses");
        if (!_infoExpenses.equals(_existingExpenses)) {
          return new RoomOpenHelper.ValidationResult(false, "expenses(com.yourpackagename.dairyapp.models.Expense).\n"
                  + " Expected:\n" + _infoExpenses + "\n"
                  + " Found:\n" + _existingExpenses);
        }
        final HashMap<String, TableInfo.Column> _columnsSales = new HashMap<String, TableInfo.Column>(4);
        _columnsSales.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSales.put("product", new TableInfo.Column("product", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSales.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSales.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSales = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSales = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSales = new TableInfo("sales", _columnsSales, _foreignKeysSales, _indicesSales);
        final TableInfo _existingSales = TableInfo.read(db, "sales");
        if (!_infoSales.equals(_existingSales)) {
          return new RoomOpenHelper.ValidationResult(false, "sales(com.yourpackagename.dairyapp.models.Sale).\n"
                  + " Expected:\n" + _infoSales + "\n"
                  + " Found:\n" + _existingSales);
        }
        final HashMap<String, TableInfo.Column> _columnsHealthRecords = new HashMap<String, TableInfo.Column>(5);
        _columnsHealthRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("recordDate", new TableInfo.Column("recordDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("vetName", new TableInfo.Column("vetName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("treatments", new TableInfo.Column("treatments", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHealthRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHealthRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHealthRecords = new TableInfo("health_records", _columnsHealthRecords, _foreignKeysHealthRecords, _indicesHealthRecords);
        final TableInfo _existingHealthRecords = TableInfo.read(db, "health_records");
        if (!_infoHealthRecords.equals(_existingHealthRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "health_records(com.yourpackagename.dairyapp.models.HealthRecord).\n"
                  + " Expected:\n" + _infoHealthRecords + "\n"
                  + " Found:\n" + _existingHealthRecords);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d8d787a20864b670377bc4af5151f1ad", "a4c1a5b305169cb7771255d912b8eec0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "animals","expenses","sales","health_records");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `animals`");
      _db.execSQL("DELETE FROM `expenses`");
      _db.execSQL("DELETE FROM `sales`");
      _db.execSQL("DELETE FROM `health_records`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AnimalDao.class, AnimalDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExpenseDao.class, ExpenseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaleDao.class, SaleDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(HealthRecordDao.class, HealthRecordDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public AnimalDao animalDao() {
    if (_animalDao != null) {
      return _animalDao;
    } else {
      synchronized(this) {
        if(_animalDao == null) {
          _animalDao = new AnimalDao_Impl(this);
        }
        return _animalDao;
      }
    }
  }

  @Override
  public ExpenseDao expenseDao() {
    if (_expenseDao != null) {
      return _expenseDao;
    } else {
      synchronized(this) {
        if(_expenseDao == null) {
          _expenseDao = new ExpenseDao_Impl(this);
        }
        return _expenseDao;
      }
    }
  }

  @Override
  public SaleDao saleDao() {
    if (_saleDao != null) {
      return _saleDao;
    } else {
      synchronized(this) {
        if(_saleDao == null) {
          _saleDao = new SaleDao_Impl(this);
        }
        return _saleDao;
      }
    }
  }

  @Override
  public HealthRecordDao healthRecordDao() {
    if (_healthRecordDao != null) {
      return _healthRecordDao;
    } else {
      synchronized(this) {
        if(_healthRecordDao == null) {
          _healthRecordDao = new HealthRecordDao_Impl(this);
        }
        return _healthRecordDao;
      }
    }
  }
}
