#!/bin/bash

multimarkdown --to=latex content.mmd > content.tex &&
    omgtex.rb -o content.tex
