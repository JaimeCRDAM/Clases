using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista_de_la_Compra.MVVM.Models
{
    public class ListaItems
    {
        public List<Item> Items { get; set; }
        public ListaItems()
        {
            Items = new List<Item>();
        }
		public int totalItems
		{
			get { return Items.Count-itemsComprados; }
		}

        public int itemsComprados
        {
            get { return Items.Count(i => i.Comprado); }
        }

    }
}
