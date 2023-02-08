using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PlantillasV2.Forms
{
    public partial class Triangulos : Form
    {
        public Triangulos()
        {
            InitializeComponent();
        }

        private void BTNComprobar_Click(object sender, EventArgs e)
        {
            int ladoA = (int)Convert.ChangeType(TBLadoA.Text, typeof(int));
            int ladoB = (int)Convert.ChangeType(TBLadoB.Text, typeof(int));
            int ladoC = (int)Convert.ChangeType(TBLadoC.Text, typeof(int));
            if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC)
            {
                if (ladoA == ladoC && ladoA == ladoB)
                {
                    MessageBox.Show("Es equilatero");
                }
                if (ladoA != ladoC || ladoA != ladoB)
                {
                    MessageBox.Show("Es isosceles");
                }

            }
            else
            {
                if (ladoA != ladoC && ladoC != ladoB)
                {
                    MessageBox.Show("Es escaleno");
                }
            }
        }
    }
}
