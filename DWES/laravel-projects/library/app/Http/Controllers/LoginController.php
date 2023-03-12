<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LoginController extends Controller
{
    public function loginForm()
    {
        return view('auth.login');
    }

    public function login(Request $request)
    {
        $credentials = $request->only('login', 'password');
        if (Auth::attempt($credentials)) {
            return redirect()->intended(route('index'));
        } else {
            $error = 'Incorrect user';
            return view('auth.login', compact('error'));
        }
    }

    public function logout()
    {
        Auth::logout();
        return redirect()->intended(route('index'));
    }
}
