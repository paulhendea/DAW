using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using Carreras.Data;
using System;
using System.Linq;
using Carreras.Models;
using System.Globalization;

namespace Carreras.SeedData;

public class SeedData
{
    public static void Initialize(IServiceProvider serviceProvider)
    {
        using (var context = new CarrerasContext(
            serviceProvider.GetRequiredService<DbContextOptions<CarrerasContext>>()
        ))
        {
            // Look for any movies.
            if (context.Participante.Any())
            {
                return;   // DB has been seeded
            }

            context.Carreras.AddRange(
                new Carrera
                {
                    NumeroCarrera = 0,
                    Descripcion = "Carrera de prueba",
                    Fecha = DateTime.Now,
                    HoraInicio = DateTime.ParseExact("18:00:00", "HH:mm:ss", new CultureInfo("es-Es")),
                    DistanciaEnMetros = 10000,
                    Participantes = context.Participante.ToList(),
                }
            );
            context.SaveChanges();

            context.Participante.AddRange(
                new Participante
                {
                    Dorsal = "A02D0D8",
                    Apellidos = "Hendea",
                    Nombre = "Paul",
                    DNI = "x5752177",
                    Club = "Dragon",
                    PosicionGeneral = 1,
                    TiempoOficial = new DateTime(0),
                }, 
                new Participante
                {
                    Dorsal = "A6B3780",
                    Apellidos = "A",
                    Nombre = "a",
                    DNI = "a",
                    Club = "Dragon",
                    PosicionGeneral = 2,
                    TiempoOficial = new DateTime(0),
                },
                new Participante
                {
                    Dorsal = "A6B354F",
                    Apellidos = "b",
                    Nombre = "b",
                    DNI = "b",
                    Club = "Dragon",
                    PosicionGeneral = 3,
                    TiempoOficial = new DateTime(0),
                },
                new Participante
                {
                    Dorsal = "AA7F3A8",
                    Apellidos = "c",
                    Nombre = "c",
                    DNI = "c",
                    Club = "Dragon",
                    PosicionGeneral = 4,
                    TiempoOficial = new DateTime(0),
                },
                new Participante
                {
                    Dorsal = "A6B2EC3",
                    Apellidos = "d",
                    Nombre = "d",
                    DNI = "d",
                    Club = "Dragon",
                    PosicionGeneral = 5,
                    TiempoOficial = new DateTime(0),
                },
                new Participante
                {
                    Dorsal = "A6B303A",
                    Apellidos = "e",
                    Nombre = "e",
                    DNI = "e",
                    Club = "Dragon",
                    PosicionGeneral = 6,
                    TiempoOficial = new DateTime(0),
                }

            );
            context.SaveChanges();
        }
    }
}
