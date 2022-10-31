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
    public partial class Cajas : Form
    {
        string[] items = {"Rojor","Verder","Naranjar","Marroner"};
        public Cajas()
        {

            InitializeComponent();
            CBNormal.Items.AddRange(items);
            CBList.Items.AddRange(items);
            CBSimple.Items.AddRange(items);
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void CBSimple_SelectedIndexChanged(object sender, EventArgs e)
        {
            SelectedColor.Text = CBSimple.Text;
        }

        private void CBList_SelectedIndexChanged(object sender, EventArgs e)
        {
            SelectedColor.Text = CBList.Text;
        }

        private void CBNormal_SelectedIndexChanged(object sender, EventArgs e)
        {
            SelectedColor.Text = CBNormal.Text;
        }

        private void BTNAddColor(object sender, EventArgs e)
        {
            CBNormal.Items.Add(ColorToAdd.Text);
            CBList.Items.Add(ColorToAdd.Text);
            CBSimple.Items.Add(ColorToAdd.Text);
        }
    }
}
