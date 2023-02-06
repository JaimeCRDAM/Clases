namespace Informes
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource1 = new Microsoft.Reporting.WinForms.ReportDataSource();
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource2 = new Microsoft.Reporting.WinForms.ReportDataSource();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.videoclubDataSet = new Informes.videoclubDataSet();
            this.peliculasBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.peliculasTableAdapter = new Informes.videoclubDataSetTableAdapters.peliculasTableAdapter();
            this.sociosBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sociosTableAdapter = new Informes.videoclubDataSetTableAdapters.sociosTableAdapter();
            this.panel1 = new System.Windows.Forms.Panel();
            this.TBAño = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.videoclubDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sociosBindingSource)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.peliculasBindingSource;
            reportDataSource2.Name = "DataSet2";
            reportDataSource2.Value = this.sociosBindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource2);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "Informes.Report1.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(354, 426);
            this.reportViewer1.TabIndex = 0;
            // 
            // videoclubDataSet
            // 
            this.videoclubDataSet.DataSetName = "videoclubDataSet";
            this.videoclubDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // peliculasBindingSource
            // 
            this.peliculasBindingSource.DataMember = "peliculas";
            this.peliculasBindingSource.DataSource = this.videoclubDataSet;
            // 
            // peliculasTableAdapter
            // 
            this.peliculasTableAdapter.ClearBeforeFill = true;
            // 
            // sociosBindingSource
            // 
            this.sociosBindingSource.DataMember = "socios";
            this.sociosBindingSource.DataSource = this.videoclubDataSet;
            // 
            // sociosTableAdapter
            // 
            this.sociosTableAdapter.ClearBeforeFill = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.reportViewer1);
            this.panel1.Location = new System.Drawing.Point(434, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(354, 426);
            this.panel1.TabIndex = 1;
            // 
            // TBAño
            // 
            this.TBAño.Location = new System.Drawing.Point(147, 12);
            this.TBAño.Name = "TBAño";
            this.TBAño.Size = new System.Drawing.Size(100, 20);
            this.TBAño.TabIndex = 2;
            this.TBAño.TextChanged += new System.EventHandler(this.TBAño_TextChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.TBAño);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.videoclubDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sociosBindingSource)).EndInit();
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private videoclubDataSet videoclubDataSet;
        private System.Windows.Forms.BindingSource peliculasBindingSource;
        private videoclubDataSetTableAdapters.peliculasTableAdapter peliculasTableAdapter;
        private System.Windows.Forms.BindingSource sociosBindingSource;
        private videoclubDataSetTableAdapters.sociosTableAdapter sociosTableAdapter;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TextBox TBAño;
    }
}

