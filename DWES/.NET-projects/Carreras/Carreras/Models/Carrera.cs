using Microsoft.Extensions.Diagnostics.HealthChecks;
using System.ComponentModel.DataAnnotations;

namespace Carreras.Models
{
    public class Carrera
    {
        public int Id { get; set; }
        public int NumeroCarrera { get; set; }
        [StringLength(400)]
        public string Descripcion { get; set; }

        [DataType(DataType.Date)]
        public DateTime Fecha { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:HH:mm:ss}")]
        public DateTime HoraInicio { get; set; }
        public float DistanciaEnMetros { get; set; }
        public ICollection<Participante>? Participantes { get; set;}
    }
}
