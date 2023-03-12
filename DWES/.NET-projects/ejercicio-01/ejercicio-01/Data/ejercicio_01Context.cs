using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using ejercicio_01.Models;

namespace ejercicio_01.Data
{
    public class ejercicio_01Context : DbContext
    {
        public ejercicio_01Context (DbContextOptions<ejercicio_01Context> options)
            : base(options)
        {
        }

        public DbSet<ejercicio_01.Models.Movie> Movie { get; set; } = default!;
    }
}
