<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ProtectedController extends Controller
{

    public function __construct()
    {
        $this->middleware('auth',);
    }
    
    public function protected()
    {
        return 'Welcome to the protected zone :)';
    }
}
