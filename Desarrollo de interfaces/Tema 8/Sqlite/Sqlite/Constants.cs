using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sqlite
{
    static class Constants
    {
        private const string _dbFileName = "Sqlite2.db3";
        public const SQLite.SQLiteOpenFlags Flags =
            SQLite.SQLiteOpenFlags.ReadWrite |
            SQLite.SQLiteOpenFlags.Create |
            SQLite.SQLiteOpenFlags.SharedCache;
        public static string DatabasePath => Path.Combine(FileSystem.AppDataDirectory, _dbFileName);
    }
}
