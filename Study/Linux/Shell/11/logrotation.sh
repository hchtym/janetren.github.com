#maximum log size
alarmrate=500
# The max size file can reach
file_max_size=5
# This is the directory where fresh logs are originally written
log_ram_dir=/var/log
# This is the directory where backup logs are kept
working_dir=/mnt/soho_storage/log
# This is the frequency our program runs
SLEEPTIME=5


# Append YEAR.MONTH.DAY and timestamp to log file
filenameConvert()
{
	timestamp=$(date +%Y%m%d%H%M%S)
	timestamp=`echo $timestamp`
	RETVAL=$1.$timestamp
}

# search dir to fetch the oldest log
searchdir()
{
    oldestlog=`ls -rt |head -n 1|awk '{print $1}'`
}

# This function clean old logs under working dir if it reaches it’s size limitation, say 500M.
clear_old_log_under_working_dir()
 {
	cd $working_dir
  	while true;
               do
  	        logsize=`du -ms $working_dir | awk '{ print $1 }'`
                       if [ $logsize -gt $alarmrate ];
                       then
	                searchdir
    	                rm -rf $oldestlog
    	        else
	                break;
	        fi
	 done
}

# This is the main process of our log backup activity.
backuplog_process()
{
	cd $log_ram_dir
	for i in * ;do
		file_size=`du -m $i | awk '{print $1}'`
		case $i in
		access.log | error.log | apcupsd.events | evms-engine.log |\
		messages | soho.log | kern.log | lpr.log | mail.err |\
		mail.info | mail.log | mail.warn | news |\
		rsyncd.log | user.log | dmesg | dmesg.0 | dmesg.new)
			if [ ! -d $working_dir ]; then
				mkdir -p $working_dir
			fi
			if [ file_size -gz file_max_size ]; then
				filenameConvert $i
				cp $log_ram_dir/$i $working_dir/$RETVAL
				echo "" >$log_ram_dir/$i
				clear_old_log_under_working_dir
			fi
			;;
		*)
			if [ file_size -gz file_max_size ]; then
				echo "" >$log_ram_dir/$i
			fi
		esac
	done
}

while true ;do
	backuplog_process
	sleep $SLEEPTIME
done

