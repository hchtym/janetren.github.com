BEGIN {										
#注释1
  print "How many people with nologin?"
}
/nologin/ {++adder}							#注释2
END {										
#注释3
  print "'nologin' appears " adder " times."
}

