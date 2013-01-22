BEGIN {
  FS = ":"														
＃注释1
}
NF != 7 {														
＃注释2
  printf("line %d, does not have 7 fields:%s\n",NR,$0)
} 
$1 !~ /[A-Za-z0-9]/{												
＃注释3
  printf("line %d, non alpha and numeric user id: %s\n",NR,$0)
} 
$2 == "*" {													
＃注释4
  printf("line %d, no password: %s\n",NR,$0)
}

