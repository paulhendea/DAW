using System.ComponentModel.DataAnnotations;

namespace Carreras.Models
{
    public class Participante
    {
        public int Id { get; set; }
        public string Dorsal { get; set; }
        public string Apellidos { get; set; }
        public string Nombre { get; set; }
        public string DNI { get; set; }
        public string Club { get; set; }
        public int PosicionGeneral { get; set; }
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:HH:mm:ss}")]
        public DateTime TiempoOficial { get; set; }
        public ICollection<Carrera>? Carreras { get; set; }

    }
}
