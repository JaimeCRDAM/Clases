namespace SG_PORRAJaime.Administrar_carpeta
{
    partial class Usuarios
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
            this.DGVUsuarios = new System.Windows.Forms.DataGridView();
            this.BTNAñadir = new System.Windows.Forms.Button();
            this.BTNModificar = new System.Windows.Forms.Button();
            this.BTNEliminar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVUsuarios)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVUsuarios
            // 
            this.DGVUsuarios.AllowUserToAddRows = false;
            this.DGVUsuarios.AllowUserToDeleteRows = false;
            this.DGVUsuarios.AllowUserToResizeColumns = false;
            this.DGVUsuarios.AllowUserToResizeRows = false;
            this.DGVUsuarios.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVUsuarios.Location = new System.Drawing.Point(12, 12);
            this.DGVUsuarios.Name = "DGVUsuarios";
            this.DGVUsuarios.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.DGVUsuarios.Size = new System.Drawing.Size(776, 368);
            this.DGVUsuarios.TabIndex = 0;
            this.DGVUsuarios.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.DGVUsuarios_CellContentClick);
            this.DGVUsuarios.CellContentDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.DGVUsuarios_CellContentDoubleClick);
            // 
            // BTNAñadir
            // 
            this.BTNAñadir.Location = new System.Drawing.Point(12, 415);
            this.BTNAñadir.Name = "BTNAñadir";
            this.BTNAñadir.Size = new System.Drawing.Size(75, 23);
            this.BTNAñadir.TabIndex = 1;
            this.BTNAñadir.Text = "Añadir";
            this.BTNAñadir.UseVisualStyleBackColor = true;
            this.BTNAñadir.Click += new System.EventHandler(this.BTNAñadir_Click);
            // 
            // BTNModificar
            // 
            this.BTNModificar.Location = new System.Drawing.Point(367, 415);
            this.BTNModificar.Name = "BTNModificar";
            this.BTNModificar.Size = new System.Drawing.Size(75, 23);
            this.BTNModificar.TabIndex = 2;
            this.BTNModificar.Text = "Modificar";
            this.BTNModificar.UseVisualStyleBackColor = true;
            this.BTNModificar.Click += new System.EventHandler(this.BTNModificar_Click);
            // 
            // BTNEliminar
            // 
            this.BTNEliminar.Location = new System.Drawing.Point(713, 415);
            this.BTNEliminar.Name = "BTNEliminar";
            this.BTNEliminar.Size = new System.Drawing.Size(75, 23);
            this.BTNEliminar.TabIndex = 3;
            this.BTNEliminar.Text = "Eliminar";
            this.BTNEliminar.UseVisualStyleBackColor = true;
            this.BTNEliminar.Click += new System.EventHandler(this.BTNEliminar_Click);
            // 
            // Usuarios
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDark;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.BTNEliminar);
            this.Controls.Add(this.BTNModificar);
            this.Controls.Add(this.BTNAñadir);
            this.Controls.Add(this.DGVUsuarios);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.ImeMode = System.Windows.Forms.ImeMode.Off;
            this.Name = "Usuarios";
            this.Text = "Usuarios";
            ((System.ComponentModel.ISupportInitialize)(this.DGVUsuarios)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVUsuarios;
        private System.Windows.Forms.Button BTNAñadir;
        private System.Windows.Forms.Button BTNModificar;
        private System.Windows.Forms.Button BTNEliminar;
    }
}