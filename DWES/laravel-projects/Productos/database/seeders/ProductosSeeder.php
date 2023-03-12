<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Categoria;
use App\Models\Producto;

class ProductosSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $categorias = Categoria::all();
        $categorias->each(function ($categoria) {
            Producto::factory()->count(25)->create([
                'categoria_id' => $categoria->id,
            ]);
        });
    }
}
