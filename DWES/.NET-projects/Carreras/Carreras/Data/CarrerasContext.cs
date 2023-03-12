using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Carreras.Models;

namespace Carreras.Data
{
    public class CarrerasContext : DbContext
    {
        public CarrerasContext (DbContextOptions<CarrerasContext> options)
            : base(options)
        {
        }

        public DbSet<Carreras.Models.Participante> Participante { get; set; } = default!;
        public DbSet<Carreras.Models.Carrera> Carreras { get; set; } = default!;
    }
}
