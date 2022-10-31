using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Videoclub.VBDSTableAdapters;

namespace Videoclub
{
    public partial class FormTabla : Form
    {
        public FormTabla()
        {
            InitializeComponent();
        }

        private void sociosBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.sociosBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.vBDS);

        }

        private void FormTabla_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'vBDS.socios' Puede moverla o quitarla según sea necesario.
            this.sociosTableAdapter.Fill(this.vBDS.socios);

        }

        private void bindingNavigatorDeleteItem_Click(object sender, EventArgs e)
        {
            DialogResult rs = MessageBox.Show("Quieres eliminar", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (rs == DialogResult.Yes)
            {
                alquileresTableAdapter alquileres = new alquileresTableAdapter();
                int id = Convert.ToInt32(3);
                var alquileresSocio = alquileres.GetDataBySocio(id);
                if (alquileresSocio.Count > 0)
                {
                    MessageBox.Show("Este socio tiene alquileres pendientes");
                    DialogResult eliminar = MessageBox.Show("Quieres eliminar alquiler y socio", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                    if (eliminar == DialogResult.Yes)
                    {
                        alquileres.DeleteBySocio(id);
                        deleteSocioById(id);
                    }
                    return;
                }
                deleteSocioById(id);

            }
        }
        private void deleteSocioById(int id)
        {
            if (sociosTableAdapter.Delete(id) > 0)
            {
                MessageBox.Show("Que si pesao");
            }
            sociosTableAdapter.Fill(this.vBDS.socios);
        }
    }
}
