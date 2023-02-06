using SG_PORRAJaime.bd_porraDataSetTableAdapters;
using SG_PORRAJaime.DB;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime.Administrar_carpeta
{
    public partial class Equipos : Form
    {
        public Equipos()
        {
            InitializeComponent();
        }

        private void eQUIPOSBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.eQUIPOSBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);

        }

        private void eQUIPOSBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            DialogResult guardar = MessageBox.Show("Desea guardar el equipo seleccionado?", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (guardar == DialogResult.Yes)
            {
                this.Validate();
                this.eQUIPOSBindingSource.EndEdit();
                this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);
            }

        }

        private void Equipos_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'bd_porraDataSet.EQUIPOS' Puede moverla o quitarla según sea necesario.
            this.eQUIPOSTableAdapter.Fill(this.bd_porraDataSet.EQUIPOS);

        }

        private void BTNFoto_Click(object sender, EventArgs e)
        {
            OpenFileDialog escudo = new OpenFileDialog();
            escudo.Filter = "(*.jpg, *.jpeg, *.bmp, *.png)|*.jpg;*.jpeg;*.bmp;*.png";
            if (escudo.ShowDialog() == DialogResult.OK)
            {
                string fileName = escudo.FileName;
                var fileBytes = File.ReadAllBytes(fileName);
                EQUIPOSTableAdapter equipos = new EQUIPOSTableAdapter();
                var id = Convert.ToInt32(id_equipoLabel1.Text.ToString());
                equipos.ActualizarEscudo(fileBytes, id, id);
                //escudoPictureBox.Image = ByteToImage(fileBytes);
                this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);
                return;
            }
        }

        private void bindingNavigatorDeleteItem_Click(object sender, EventArgs e)
        {
            DialogResult eliminar = MessageBox.Show("Desea eliminar el equipo seleccionado?", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (eliminar == DialogResult.Yes)
            {
                PARTIDOSTableAdapter partidosDB = new PARTIDOSTableAdapter();
                var id = Convert.ToInt32(id_equipoLabel1.Text.ToString());
                var result = partidosDB.GetPartidosConIdV2(id);
                if (result.Count > 0)
                {
                    MessageBox.Show("Este equipo no se puede eliminar, tiene partidos");
                    this.eQUIPOSTableAdapter.Fill(this.bd_porraDataSet.EQUIPOS);
                    return;
                }
                EQUIPOSTableAdapter equiposDb = new EQUIPOSTableAdapter();
                equiposDb.DeleteEquipo(id);
                MessageBox.Show("Se ha eliminado correctamente el equipo");
                this.eQUIPOSTableAdapter.Fill(this.bd_porraDataSet.EQUIPOS);
            }
        }
        public static Bitmap ByteToImage(byte[] blob)
        {
            MemoryStream mStream = new MemoryStream();
            byte[] pData = blob;
            mStream.Write(pData, 0, Convert.ToInt32(pData.Length));
            Bitmap bm = new Bitmap(mStream, false);
            mStream.Dispose();
            return bm;
        }
    }
}
