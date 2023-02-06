namespace Informes_Ertes
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.bd_ertesDataSet = new Informes_Ertes.bd_ertesDataSet();
            this.bdertesDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.eMPLEADOSBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.eMPLEADOSTableAdapter = new Informes_Ertes.bd_ertesDataSetTableAdapters.EMPLEADOSTableAdapter();
            this.eMPRESASBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.eMPRESASTableAdapter = new Informes_Ertes.bd_ertesDataSetTableAdapters.EMPRESASTableAdapter();
            this.dataTable1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.dataTable1TableAdapter = new Informes_Ertes.bd_ertesDataSetTableAdapters.DataTable1TableAdapter();
            this.dataTable1BindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.bdertesDataSetBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.dataTable1BindingSource2 = new System.Windows.Forms.BindingSource(this.components);
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bd_ertesDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bdertesDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.eMPLEADOSBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.eMPRESASBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bdertesDataSetBindingSource1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource2)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.reportViewer1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel1.Location = new System.Drawing.Point(0, 88);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(800, 362);
            this.panel1.TabIndex = 0;
            // 
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.dataTable1BindingSource2;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "Informes_Ertes.Report1.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(800, 362);
            this.reportViewer1.TabIndex = 1;
            // 
            // bd_ertesDataSet
            // 
            this.bd_ertesDataSet.DataSetName = "bd_ertesDataSet";
            this.bd_ertesDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bdertesDataSetBindingSource
            // 
            this.bdertesDataSetBindingSource.DataSource = this.bd_ertesDataSet;
            this.bdertesDataSetBindingSource.Position = 0;
            // 
            // eMPLEADOSBindingSource
            // 
            this.eMPLEADOSBindingSource.DataMember = "EMPLEADOS";
            this.eMPLEADOSBindingSource.DataSource = this.bd_ertesDataSet;
            // 
            // eMPLEADOSTableAdapter
            // 
            this.eMPLEADOSTableAdapter.ClearBeforeFill = true;
            // 
            // eMPRESASBindingSource
            // 
            this.eMPRESASBindingSource.DataMember = "EMPRESAS";
            this.eMPRESASBindingSource.DataSource = this.bd_ertesDataSet;
            // 
            // eMPRESASTableAdapter
            // 
            this.eMPRESASTableAdapter.ClearBeforeFill = true;
            // 
            // dataTable1BindingSource
            // 
            this.dataTable1BindingSource.DataMember = "DataTable1";
            this.dataTable1BindingSource.DataSource = this.bd_ertesDataSet;
            // 
            // dataTable1TableAdapter
            // 
            this.dataTable1TableAdapter.ClearBeforeFill = true;
            // 
            // dataTable1BindingSource1
            // 
            this.dataTable1BindingSource1.DataMember = "DataTable1";
            this.dataTable1BindingSource1.DataSource = this.bd_ertesDataSet;
            // 
            // bdertesDataSetBindingSource1
            // 
            this.bdertesDataSetBindingSource1.DataSource = this.bd_ertesDataSet;
            this.bdertesDataSetBindingSource1.Position = 0;
            // 
            // dataTable1BindingSource2
            // 
            this.dataTable1BindingSource2.DataMember = "DataTable1";
            this.dataTable1BindingSource2.DataSource = this.bd_ertesDataSet;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.bd_ertesDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bdertesDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.eMPLEADOSBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.eMPRESASBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bdertesDataSetBindingSource1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private System.Windows.Forms.BindingSource bdertesDataSetBindingSource;
        private bd_ertesDataSet bd_ertesDataSet;
        private System.Windows.Forms.BindingSource eMPLEADOSBindingSource;
        private bd_ertesDataSetTableAdapters.EMPLEADOSTableAdapter eMPLEADOSTableAdapter;
        private System.Windows.Forms.BindingSource eMPRESASBindingSource;
        private bd_ertesDataSetTableAdapters.EMPRESASTableAdapter eMPRESASTableAdapter;
        private System.Windows.Forms.BindingSource dataTable1BindingSource;
        private bd_ertesDataSetTableAdapters.DataTable1TableAdapter dataTable1TableAdapter;
        private System.Windows.Forms.BindingSource dataTable1BindingSource1;
        private System.Windows.Forms.BindingSource bdertesDataSetBindingSource1;
        private System.Windows.Forms.BindingSource dataTable1BindingSource2;
    }
}

