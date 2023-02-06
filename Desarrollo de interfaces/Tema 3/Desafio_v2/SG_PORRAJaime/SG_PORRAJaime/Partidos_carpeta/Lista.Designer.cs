namespace SG_PORRAJaime.Partidos_carpeta
{
    partial class Lista
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
            this.DGVPartidos = new System.Windows.Forms.DataGridView();
            this.BTNApuesta = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVPartidos)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVPartidos
            // 
            this.DGVPartidos.AllowUserToAddRows = false;
            this.DGVPartidos.AllowUserToDeleteRows = false;
            this.DGVPartidos.AllowUserToResizeColumns = false;
            this.DGVPartidos.AllowUserToResizeRows = false;
            this.DGVPartidos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVPartidos.Location = new System.Drawing.Point(12, 12);
            this.DGVPartidos.Name = "DGVPartidos";
            this.DGVPartidos.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.DisableResizing;
            this.DGVPartidos.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.DGVPartidos.Size = new System.Drawing.Size(776, 372);
            this.DGVPartidos.TabIndex = 0;
            // 
            // BTNApuesta
            // 
            this.BTNApuesta.Location = new System.Drawing.Point(247, 415);
            this.BTNApuesta.Name = "BTNApuesta";
            this.BTNApuesta.Size = new System.Drawing.Size(75, 23);
            this.BTNApuesta.TabIndex = 1;
            this.BTNApuesta.Text = "Apuesta";
            this.BTNApuesta.UseVisualStyleBackColor = true;
            this.BTNApuesta.Click += new System.EventHandler(this.BTNApuesta_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(376, 415);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 2;
            this.button2.Text = "button2";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Lista
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.BTNApuesta);
            this.Controls.Add(this.DGVPartidos);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Lista";
            this.Text = "Lista";
            ((System.ComponentModel.ISupportInitialize)(this.DGVPartidos)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVPartidos;
        private System.Windows.Forms.Button BTNApuesta;
        private System.Windows.Forms.Button button2;
    }
}