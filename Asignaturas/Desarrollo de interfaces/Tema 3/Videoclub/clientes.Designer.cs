namespace Videoclub
{
    partial class clientes
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.vBDS = new Videoclub.VBDS();
            this.sociosBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sociosTableAdapter = new Videoclub.VBDSTableAdapters.sociosTableAdapter();
            this.idSocioDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.loginDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pwdDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.apell1DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.apell2DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.direccionDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.localidadDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.telefonoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.emailDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.BTNGuardar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.vBDS)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sociosBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idSocioDataGridViewTextBoxColumn,
            this.loginDataGridViewTextBoxColumn,
            this.pwdDataGridViewTextBoxColumn,
            this.nombreDataGridViewTextBoxColumn,
            this.apell1DataGridViewTextBoxColumn,
            this.apell2DataGridViewTextBoxColumn,
            this.direccionDataGridViewTextBoxColumn,
            this.localidadDataGridViewTextBoxColumn,
            this.telefonoDataGridViewTextBoxColumn,
            this.emailDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.sociosBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(12, 12);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView1.Size = new System.Drawing.Size(1049, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // vBDS
            // 
            this.vBDS.DataSetName = "VBDS";
            this.vBDS.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sociosBindingSource
            // 
            this.sociosBindingSource.DataMember = "socios";
            this.sociosBindingSource.DataSource = this.vBDS;
            // 
            // sociosTableAdapter
            // 
            this.sociosTableAdapter.ClearBeforeFill = true;
            // 
            // idSocioDataGridViewTextBoxColumn
            // 
            this.idSocioDataGridViewTextBoxColumn.DataPropertyName = "idSocio";
            this.idSocioDataGridViewTextBoxColumn.HeaderText = "idSocio";
            this.idSocioDataGridViewTextBoxColumn.Name = "idSocioDataGridViewTextBoxColumn";
            this.idSocioDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // loginDataGridViewTextBoxColumn
            // 
            this.loginDataGridViewTextBoxColumn.DataPropertyName = "login";
            this.loginDataGridViewTextBoxColumn.HeaderText = "login";
            this.loginDataGridViewTextBoxColumn.Name = "loginDataGridViewTextBoxColumn";
            // 
            // pwdDataGridViewTextBoxColumn
            // 
            this.pwdDataGridViewTextBoxColumn.DataPropertyName = "pwd";
            this.pwdDataGridViewTextBoxColumn.HeaderText = "pwd";
            this.pwdDataGridViewTextBoxColumn.Name = "pwdDataGridViewTextBoxColumn";
            // 
            // nombreDataGridViewTextBoxColumn
            // 
            this.nombreDataGridViewTextBoxColumn.DataPropertyName = "nombre";
            this.nombreDataGridViewTextBoxColumn.HeaderText = "nombre";
            this.nombreDataGridViewTextBoxColumn.Name = "nombreDataGridViewTextBoxColumn";
            // 
            // apell1DataGridViewTextBoxColumn
            // 
            this.apell1DataGridViewTextBoxColumn.DataPropertyName = "apell1";
            this.apell1DataGridViewTextBoxColumn.HeaderText = "apell1";
            this.apell1DataGridViewTextBoxColumn.Name = "apell1DataGridViewTextBoxColumn";
            // 
            // apell2DataGridViewTextBoxColumn
            // 
            this.apell2DataGridViewTextBoxColumn.DataPropertyName = "apell2";
            this.apell2DataGridViewTextBoxColumn.HeaderText = "apell2";
            this.apell2DataGridViewTextBoxColumn.Name = "apell2DataGridViewTextBoxColumn";
            // 
            // direccionDataGridViewTextBoxColumn
            // 
            this.direccionDataGridViewTextBoxColumn.DataPropertyName = "direccion";
            this.direccionDataGridViewTextBoxColumn.HeaderText = "direccion";
            this.direccionDataGridViewTextBoxColumn.Name = "direccionDataGridViewTextBoxColumn";
            // 
            // localidadDataGridViewTextBoxColumn
            // 
            this.localidadDataGridViewTextBoxColumn.DataPropertyName = "localidad";
            this.localidadDataGridViewTextBoxColumn.HeaderText = "localidad";
            this.localidadDataGridViewTextBoxColumn.Name = "localidadDataGridViewTextBoxColumn";
            // 
            // telefonoDataGridViewTextBoxColumn
            // 
            this.telefonoDataGridViewTextBoxColumn.DataPropertyName = "telefono";
            this.telefonoDataGridViewTextBoxColumn.HeaderText = "telefono";
            this.telefonoDataGridViewTextBoxColumn.Name = "telefonoDataGridViewTextBoxColumn";
            // 
            // emailDataGridViewTextBoxColumn
            // 
            this.emailDataGridViewTextBoxColumn.DataPropertyName = "email";
            this.emailDataGridViewTextBoxColumn.HeaderText = "email";
            this.emailDataGridViewTextBoxColumn.Name = "emailDataGridViewTextBoxColumn";
            // 
            // BTNGuardar
            // 
            this.BTNGuardar.Location = new System.Drawing.Point(353, 202);
            this.BTNGuardar.Name = "BTNGuardar";
            this.BTNGuardar.Size = new System.Drawing.Size(75, 23);
            this.BTNGuardar.TabIndex = 1;
            this.BTNGuardar.Text = "Guardar";
            this.BTNGuardar.UseVisualStyleBackColor = true;
            this.BTNGuardar.Click += new System.EventHandler(this.BTNGuardar_Click);
            // 
            // clientes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(1055, 450);
            this.Controls.Add(this.BTNGuardar);
            this.Controls.Add(this.dataGridView1);
            this.Name = "clientes";
            this.Text = "clientes";
            this.Load += new System.EventHandler(this.clientes_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.vBDS)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sociosBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private VBDS vBDS;
        private System.Windows.Forms.BindingSource sociosBindingSource;
        private VBDSTableAdapters.sociosTableAdapter sociosTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn idSocioDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn loginDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn pwdDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn apell1DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn apell2DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn direccionDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn localidadDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn telefonoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn emailDataGridViewTextBoxColumn;
        private System.Windows.Forms.Button BTNGuardar;
    }
}