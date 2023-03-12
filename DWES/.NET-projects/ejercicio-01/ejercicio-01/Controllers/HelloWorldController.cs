using Microsoft.AspNetCore.Mvc;
using System.Text.Encodings.Web;

namespace ejercicio_01.Controllers;

public class HelloWorldController : Controller
{

    public IActionResult Index()
    {
        return View();
    }

    public IActionResult Welcome(string name = "world", int numberOfTimes = 1)
    {
        ViewData["Message"] = "Hello " + name;
        ViewData["numberOfTimes"] = numberOfTimes;
        return View();
    }
}
