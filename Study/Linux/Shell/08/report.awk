#/usr/bin/awk -f（这一行可以不要）
BEGIN {
	FS=":"; OFS="\t"							
#注释1
    print "name\tphone\t\tJan\tFeb\tMar\t\tTotal"
    print "______________________________________________________"
};
{$6 = $3 + $4 + $5}
{print $1"\t"$2"\t"$3"\t"$4"\t"$5"\t\t"$6}			#注释2
{total3 +=$3}									
#注释3
{total4 +=$4}
{total5 +=$5}
END {
	print "______________________________________________________" 
    print "this is Jan total: " total3
    print "this is Feb total: " total4
    print "this is Mar total: " total5
}

