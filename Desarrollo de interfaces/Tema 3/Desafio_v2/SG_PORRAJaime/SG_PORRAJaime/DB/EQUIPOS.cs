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
    
    public partial class EQUIPOS
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public EQUIPOS()
        {
            this.PARTIDOS = new HashSet<PARTIDOS>();
            this.PARTIDOS1 = new HashSet<PARTIDOS>();
        }
    
        public int Id_equipo { get; set; }
        public string Nombre { get; set; }
        public byte[] Escudo { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<PARTIDOS> PARTIDOS { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<PARTIDOS> PARTIDOS1 { get; set; }
    }
}
