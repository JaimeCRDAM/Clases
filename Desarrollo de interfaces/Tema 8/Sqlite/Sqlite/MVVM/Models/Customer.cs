using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Sqlite.Abstractions;
using Sqlite.MVVM.Models;
using SQLite;
using SQLiteNetExtensions.Attributes;

namespace MVVM.Models
{
    [Table("Customers")]
    public class Customer : TableData
    {

        [Column("name")]
        public string Name { get; set; }
        [Column("phone"), Unique]
        public string Phone { get; set; }
        [Column("age")]
        public int Age { get; set; }
        [Column("address"), MaxLength(100)]
        public string Address { get; set; }
        [Ignore]
        public bool IsYoung => Age < 50 ? true : false;
        [OneToMany(CascadeOperations = CascadeOperation.All)]
        public List<Passport> Passport { get; set; }

    }
}
