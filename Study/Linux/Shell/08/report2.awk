#!/usr/bin/awk -f
BEGIN {
	FS=":"; OFS="\t"
    print "***            modified from report.awk         ***"
    print "name\tphone\t\tJan\tFeb\tMar\t\tTotal"
	#printf {"%-20s%-20s%-20s%-20s%-20s%20s\n",name,phone,Jan,Feb,Mar,Total};
    print "______________________________________________"
};
{$6 = $3 + $4 + $5}
#{print "\t" $1"\t"$2"\t"$3"\t"$4"\t"$5"\t"$6}
{printf "%-8s%-15s%-8s%-8s%-15s%-10s\n", $1,$2,$3,$4,$5,$6}
{total3 +=$3}
{total4 +=$4}
{total5 +=$5}
END {
    print "_____________________________________________"
    print "is Jan total; " total3
    print "is Feb total: " total4
    print "is Mar total: " total5
}

