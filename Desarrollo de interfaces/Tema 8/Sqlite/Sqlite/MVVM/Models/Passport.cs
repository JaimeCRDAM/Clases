using MVVM.Models;
using Sqlite.Abstractions;
using SQLiteNetExtensions.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sqlite.MVVM.Models
{
    public class Passport : TableData
    {
        public DateTime ExpirationDate { get; set; }

        [ForeignKey(typeof(Customer))]
        public int CustomerId { get; set; }
    }
}
