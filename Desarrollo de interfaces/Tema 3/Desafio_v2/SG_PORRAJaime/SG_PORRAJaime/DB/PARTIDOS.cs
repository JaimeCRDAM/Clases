//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SG_PORRAJaime.DB
{
    using System;
    using System.Collections.Generic;
    
    public partial class PARTIDOS
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public PARTIDOS()
        {
            this.APUESTAS = new HashSet<APUESTAS>();
        }
    
        public int Id_partido { get; set; }
        public System.DateTime Fecha { get; set; }
        public System.TimeSpan Hora { get; set; }
        public int Equipo_local { get; set; }
        public int Equipo_visitante { get; set; }
        public string Resultado { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<APUESTAS> APUESTAS { get; set; }
        public virtual EQUIPOS EQUIPOS { get; set; }
        public virtual EQUIPOS EQUIPOS1 { get; set; }
    }
}
