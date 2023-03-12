using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Carreras.Data;
using Carreras.Models;
using System.Globalization;
using System.Diagnostics;

namespace Carreras.Controllers
{
    public class ParticipantesController : Controller
    {
        private readonly CarrerasContext _context;

        public ParticipantesController(CarrerasContext context)
        {
            _context = context;
        }

        // GET: Participantes/ActualizarTiempos
        public IActionResult ActualizarTiempos()
        {
            using (StreamReader reader = new StreamReader("tiempos.txt"))
            {
                // read the captions
                reader.ReadLine();

                // read the data
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                    string[] data = line.Split(" ");
                    int numeroCarrera = Convert.ToInt32(data[0]);
                    string dorsal = data[1];
                    DateTime horaLlegada = DateTime.ParseExact(data[2], "HHmmss", new CultureInfo("es-Es"));

                    Participante participante = _context.Participante.FirstOrDefault(participante => participante.Dorsal == dorsal);
                    Carrera carrera = _context.Carreras.FirstOrDefault(carrera => carrera.NumeroCarrera == numeroCarrera);

                    if (participante != null && carrera != null)
                    {
                        TimeSpan intervalo = horaLlegada - carrera.HoraInicio;
                        DateTime tiempoOficial = DateTime.Parse(intervalo.ToString());
                        participante.TiempoOficial = tiempoOficial;
                        _context.Update(participante);
                        _context.SaveChanges();
                    }
                }

                // close reader
                reader.Close();
            }

            return RedirectToAction("Index");
        }            

        // GET: Participantes
        public async Task<IActionResult> Index()
        {
              return _context.Participante != null ? 
                          View(await _context.Participante.ToListAsync()) :
                          Problem("Entity set 'CarrerasContext.Participante'  is null.");
        }

        // GET: Participantes/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Participante == null)
            {
                return NotFound();
            }

            var participante = await _context.Participante
                .FirstOrDefaultAsync(m => m.Id == id);
            if (participante == null)
            {
                return NotFound();
            }

            return View(participante);
        }

        // GET: Participantes/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Participantes/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Dorsal,Apellidos,Nombre,DNI,Club,PosicionGeneral,TiempoOficial")] Participante participante)
        {
            if (ModelState.IsValid)
            {
                _context.Add(participante);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(participante);
        }

        // GET: Participantes/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Participante == null)
            {
                return NotFound();
            }

            var participante = await _context.Participante.FindAsync(id);
            if (participante == null)
            {
                return NotFound();
            }
            return View(participante);
        }

        // POST: Participantes/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Dorsal,Apellidos,Nombre,DNI,Club,PosicionGeneral,TiempoOficial")] Participante participante)
        {
            if (id != participante.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(participante);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!ParticipanteExists(participante.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(participante);
        }

        // GET: Participantes/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Participante == null)
            {
                return NotFound();
            }

            var participante = await _context.Participante
                .FirstOrDefaultAsync(m => m.Id == id);
            if (participante == null)
            {
                return NotFound();
            }

            return View(participante);
        }

        // POST: Participantes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Participante == null)
            {
                return Problem("Entity set 'CarrerasContext.Participante'  is null.");
            }
            var participante = await _context.Participante.FindAsync(id);
            if (participante != null)
            {
                _context.Participante.Remove(participante);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool ParticipanteExists(int id)
        {
          return (_context.Participante?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
