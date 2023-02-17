using MVVM.Models;
using Sqlite.MVVM.Models;
using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Sqlite.Repositories
{
    public class CustomerRepository
    {
        private SQLiteConnection _connection;
        public string StatusMessage { get; set; }
        public CustomerRepository()
        {
            var ak = Constants.DatabasePath;
            _connection = new SQLiteConnection(ak, Constants.Flags);
            if (_connection.TableMappings.All(m => m.MappedType.Name != "Customers")){ 
                _connection.CreateTable<Customer>();
            }
        }
        //add all methods non async
        public void AddOrUpdate(Customer customer)
        {
            int result = 0;
            try
            {
                if (customer.Id != 0)
                {
                    _connection.Update(customer);
                    StatusMessage = $"{result} record(s) updated [Name: {customer.Name}]";
                }
                else
                {
                    result = _connection.Insert(customer);
                    StatusMessage = $"{result} record(s) added [Name: {customer.Name}]";
                }
            }
            catch (Exception ex)
            {
                StatusMessage = $"Failed to update {customer.Name}. Error: {ex.Message}";
            }
        }
        public void Delete(Customer customer)
        {
            try
            {
                _connection.Delete(customer);
                StatusMessage = $"{customer.Name} deleted successfully";
            }
            catch (Exception ex)
            {
                StatusMessage = $"Failed to delete {customer.Name}. Error: {ex.Message}";
            }
        }
        public Customer Get(int id)
        {
            try
            {
                return _connection.Table<Customer>().FirstOrDefault(c => c.Id == id);
            }
            catch (Exception ex)
            {
                StatusMessage = $"Failed to retrieve data. Error: {ex.Message}";
            }
            return null;
        }
        public List<Customer> GetAll(Expression<Func<Customer, bool>> predicate)
        {
            try
            {
                return _connection.Table<Customer>().ToList();
            }
            catch (Exception ex)
            {
                StatusMessage = $"Failed to retrieve data. Error: {ex.Message}";
            }
            return null;
        }
        public List<Customer> GetAll()
        {
            try
            {
                return _connection.Table<Customer>().ToList();
            }
            catch (Exception ex)
            {
                StatusMessage = $"Failed to retrieve data. Error: {ex.Message}";
            }
            return null;
        }
    }
}
