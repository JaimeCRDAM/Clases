using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Plantillas.Forms
{
    public partial class Calendario : Form
    {
        public Calendario()
        {
            InitializeComponent();
        }

        private void DatePicker(object sender, EventArgs e)
        {
            SDate.Text = dateTimePicker1.Text;
        }

        private void Calendar(object sender, DateRangeEventArgs e)
        {
            SDate.Text = monthCalendar1.SelectionStart.ToString();
        }
    }
}
