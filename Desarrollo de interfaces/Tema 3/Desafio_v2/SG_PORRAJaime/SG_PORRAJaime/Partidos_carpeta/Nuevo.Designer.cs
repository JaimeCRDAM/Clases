namespace SG_PORRAJaime.Partidos_carpeta
{
    partial class Nuevo
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label nombreLabel;
            System.Windows.Forms.Label label1;
            System.Windows.Forms.Label fechaLabel;
            System.Windows.Forms.Label horaLabel;
            this.CBLocal = new System.Windows.Forms.ComboBox();
            this.CBVisitante = new System.Windows.Forms.ComboBox();
            this.PBLocal = new System.Windows.Forms.PictureBox();
            this.PBVisitante = new System.Windows.Forms.PictureBox();
            this.DTPFecha = new System.Windows.Forms.DateTimePicker();
            this.BTNCrear = new System.Windows.Forms.Button();
            this.pARTIDOSBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bd_porraDataSet = new SG_PORRAJaime.bd_porraDataSet();
            this.eQUIPOSBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.eQUIPOSTableAdapter = new SG_PORRAJaime.bd_porraDataSetTableAdapters.EQUIPOSTableAdapter();
            this.tableAdapterManager = new SG_PORRAJaime.bd_porraDataSetTableAdapters.TableAdapterManager();
            this.pARTIDOSTableAdapter = new SG_PORRAJaime.bd_porraDataSetTableAdapters.PARTIDOSTableAdapter();
            this.NHora = new System.Windows.Forms.NumericUpDown();
            this.NumericMinuto = new System.Windows.Forms.NumericUpDown();
            nombreLabel = new System.Windows.Forms.Label();
            label1 = new System.Windows.Forms.Label();
            fechaLabel = new System.Windows.Forms.Label();
            horaLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.PBLocal)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.PBVisitante)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pARTIDOSBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bd_porraDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.eQUIPOSBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.NHora)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.NumericMinuto)).BeginInit();
            this.SuspendLayout();
            // 
            // nombreLabel
            // 
            nombreLabel.AutoSize = true;
            nombreLabel.Location = new System.Drawing.Point(13, 15);
            nombreLabel.Name = "nombreLabel";
            nombreLabel.Size = new System.Drawing.Size(62, 13);
            nombreLabel.TabIndex = 1;
            nombreLabel.Text = "EQ. LOCAL";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new System.Drawing.Point(313, 15);
            label1.Name = "label1";
            label1.Size = new System.Drawing.Size(84, 13);
            label1.TabIndex = 3;
            label1.Text = "EQ. VISITANTE";
            // 
            // fechaLabel
            // 
            fechaLabel.AutoSize = true;
            fechaLabel.Location = new System.Drawing.Point(151, 235);
            fechaLabel.Name = "fechaLabel";
            fechaLabel.Size = new System.Drawing.Size(40, 13);
            fechaLabel.TabIndex = 6;
            fechaLabel.Text = "Fecha:";
            // 
            // horaLabel
            // 
            horaLabel.AutoSize = true;
            horaLabel.Location = new System.Drawing.Point(158, 272);
            horaLabel.Name = "horaLabel";
            horaLabel.Size = new System.Drawing.Size(33, 13);
            horaLabel.TabIndex = 8;
            horaLabel.Text = "Hora:";
            // 
            // CBLocal
            // 
            this.CBLocal.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.eQUIPOSBindingSource, "Nombre", true));
            this.CBLocal.FormattingEnabled = true;
            this.CBLocal.Location = new System.Drawing.Point(81, 12);
            this.CBLocal.Name = "CBLocal";
            this.CBLocal.Size = new System.Drawing.Size(121, 21);
            this.CBLocal.TabIndex = 2;
            this.CBLocal.SelectedIndexChanged += new System.EventHandler(this.CBLocal_SelectedIndexChanged);
            // 
            // CBVisitante
            // 
            this.CBVisitante.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.eQUIPOSBindingSource, "Nombre", true));
            this.CBVisitante.FormattingEnabled = true;
            this.CBVisitante.Location = new System.Drawing.Point(403, 12);
            this.CBVisitante.Name = "CBVisitante";
            this.CBVisitante.Size = new System.Drawing.Size(121, 21);
            this.CBVisitante.TabIndex = 4;
            this.CBVisitante.SelectedIndexChanged += new System.EventHandler(this.CBVisitante_SelectedIndexChanged);
            // 
            // PBLocal
            // 
            this.PBLocal.DataBindings.Add(new System.Windows.Forms.Binding("Image", this.eQUIPOSBindingSource, "Escudo", true));
            this.PBLocal.Location = new System.Drawing.Point(41, 58);
            this.PBLocal.Name = "PBLocal";
            this.PBLocal.Size = new System.Drawing.Size(161, 144);
            this.PBLocal.TabIndex = 5;
            this.PBLocal.TabStop = false;
            // 
            // PBVisitante
            // 
            this.PBVisitante.DataBindings.Add(new System.Windows.Forms.Binding("Image", this.eQUIPOSBindingSource, "Escudo", true));
            this.PBVisitante.Location = new System.Drawing.Point(363, 58);
            this.PBVisitante.Name = "PBVisitante";
            this.PBVisitante.Size = new System.Drawing.Size(161, 144);
            this.PBVisitante.TabIndex = 6;
            this.PBVisitante.TabStop = false;
            // 
            // DTPFecha
            // 
            this.DTPFecha.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.pARTIDOSBindingSource, "Fecha", true));
            this.DTPFecha.Location = new System.Drawing.Point(197, 231);
            this.DTPFecha.Name = "DTPFecha";
            this.DTPFecha.Size = new System.Drawing.Size(200, 20);
            this.DTPFecha.TabIndex = 7;
            this.DTPFecha.ValueChanged += new System.EventHandler(this.DTPFecha_ValueChanged);
            // 
            // BTNCrear
            // 
            this.BTNCrear.Location = new System.Drawing.Point(203, 324);
            this.BTNCrear.Name = "BTNCrear";
            this.BTNCrear.Size = new System.Drawing.Size(75, 23);
            this.BTNCrear.TabIndex = 12;
            this.BTNCrear.Text = "Crear";
            this.BTNCrear.UseVisualStyleBackColor = true;
            this.BTNCrear.Click += new System.EventHandler(this.BTNCrear_Click);
            // 
            // pARTIDOSBindingSource
            // 
            this.pARTIDOSBindingSource.DataMember = "PARTIDOS";
            this.pARTIDOSBindingSource.DataSource = this.bd_porraDataSet;
            // 
            // bd_porraDataSet
            // 
            this.bd_porraDataSet.DataSetName = "bd_porraDataSet";
            this.bd_porraDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // eQUIPOSBindingSource
            // 
            this.eQUIPOSBindingSource.DataMember = "EQUIPOS";
            this.eQUIPOSBindingSource.DataSource = this.bd_porraDataSet;
            // 
            // eQUIPOSTableAdapter
            // 
            this.eQUIPOSTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.APUESTASTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.EQUIPOSTableAdapter = this.eQUIPOSTableAdapter;
            this.tableAdapterManager.PARTIDOSTableAdapter = this.pARTIDOSTableAdapter;
            this.tableAdapterManager.UpdateOrder = SG_PORRAJaime.bd_porraDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.USUARIOSTableAdapter = null;
            // 
            // pARTIDOSTableAdapter
            // 
            this.pARTIDOSTableAdapter.ClearBeforeFill = true;
            // 
            // NHora
            // 
            this.NHora.Location = new System.Drawing.Point(197, 270);
            this.NHora.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.NHora.Minimum = new decimal(new int[] {
            11,
            0,
            0,
            0});
            this.NHora.Name = "NHora";
            this.NHora.Size = new System.Drawing.Size(31, 20);
            this.NHora.TabIndex = 14;
            this.NHora.Value = new decimal(new int[] {
            11,
            0,
            0,
            0});
            // 
            // NumericMinuto
            // 
            this.NumericMinuto.Location = new System.Drawing.Point(234, 270);
            this.NumericMinuto.Maximum = new decimal(new int[] {
            30,
            0,
            0,
            0});
            this.NumericMinuto.Name = "NumericMinuto";
            this.NumericMinuto.Size = new System.Drawing.Size(31, 20);
            this.NumericMinuto.TabIndex = 15;
            // 
            // Nuevo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDark;
            this.ClientSize = new System.Drawing.Size(567, 354);
            this.Controls.Add(this.NumericMinuto);
            this.Controls.Add(this.NHora);
            this.Controls.Add(this.BTNCrear);
            this.Controls.Add(horaLabel);
            this.Controls.Add(fechaLabel);
            this.Controls.Add(this.DTPFecha);
            this.Controls.Add(this.PBVisitante);
            this.Controls.Add(this.PBLocal);
            this.Controls.Add(label1);
            this.Controls.Add(this.CBVisitante);
            this.Controls.Add(nombreLabel);
            this.Controls.Add(this.CBLocal);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Nuevo";
            this.Text = "Nuevo";
            this.Load += new System.EventHandler(this.Nuevo_Load);
            ((System.ComponentModel.ISupportInitialize)(this.PBLocal)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.PBVisitante)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pARTIDOSBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bd_porraDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.eQUIPOSBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.NHora)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.NumericMinuto)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private bd_porraDataSet bd_porraDataSet;
        private System.Windows.Forms.BindingSource eQUIPOSBindingSource;
        private bd_porraDataSetTableAdapters.EQUIPOSTableAdapter eQUIPOSTableAdapter;
        private bd_porraDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.ComboBox CBLocal;
        private System.Windows.Forms.ComboBox CBVisitante;
        private System.Windows.Forms.PictureBox PBLocal;
        private System.Windows.Forms.PictureBox PBVisitante;
        private bd_porraDataSetTableAdapters.PARTIDOSTableAdapter pARTIDOSTableAdapter;
        private System.Windows.Forms.BindingSource pARTIDOSBindingSource;
        private System.Windows.Forms.DateTimePicker DTPFecha;
        private System.Windows.Forms.Button BTNCrear;
        private System.Windows.Forms.NumericUpDown NHora;
        private System.Windows.Forms.NumericUpDown NumericMinuto;
    }
}