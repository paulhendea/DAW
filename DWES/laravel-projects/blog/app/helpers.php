<?php

use Carbon\Carbon;

function currentDate($dateFormat = 'd/m/Y')
{
  return date($dateFormat);
}

function showDate($date, $dateFormat = 'd/m/Y')
{
  return Carbon::parse($date)->format($dateFormat);
}
