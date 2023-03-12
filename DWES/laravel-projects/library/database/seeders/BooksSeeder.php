<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use app\Models\Book;
use app\Models\Author;

class BooksSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $authors = Author::all();
        $authors->each(function ($author) {
            Book::factory()->count(2)->create([
                'author_id' => $author->idf
            ]);
        });
    }
}
