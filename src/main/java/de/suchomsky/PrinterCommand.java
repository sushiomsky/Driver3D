package de.suchomsky;

/**
 * Driver3D
 * Copyright (c) 2017 Dennis Suchomsky <dennis.suchomsky@gmail.com>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * M20 - List SD Card
 * sdcard  List the contents of the SD Card. SDSUPPORT
 * List the entire contents of the SD card to serial output in the more compact DOS 8.3 format.
 * <p>
 * Marlin 1.1.0 includes file sizes in the output.
 * <p>
 * Usage
 * M20
 * Notes
 * Requires SDSUPPORT
 * <p>
 * M21 - Init SD card
 * sdcard  Attempt to detect an SD card in the slot. SDSUPPORT
 * Use this command if the SD card isn’t detected automatically.
 * <p>
 * Usage
 * M21
 * Notes
 * Requires SDSUPPORT
 * <p>
 * M22 - Release SD card
 * sdcard  Simulate ejection of the SD card SDSUPPORT
 * If Marlin gets confused about the state of the SD card, this command can be used to simulate an ejection of the SD card.
 * <p>
 * Re-insert the SD card or use M21 to enable the SD card following M22.
 */

/**
 * M20 - List SD Card
 sdcard  List the contents of the SD Card. SDSUPPORT
 List the entire contents of the SD card to serial output in the more compact DOS 8.3 format.

 Marlin 1.1.0 includes file sizes in the output.

 Usage
 M20
 Notes
 Requires SDSUPPORT
 */

/**
 M21 - Init SD card
 sdcard  Attempt to detect an SD card in the slot. SDSUPPORT
 Use this command if the SD card isn’t detected automatically.

 Usage
 M21
 Notes
 Requires SDSUPPORT
 */

/**
 M22 - Release SD card
 sdcard  Simulate ejection of the SD card SDSUPPORT
 If Marlin gets confused about the state of the SD card, this command can be used to simulate an ejection of the SD card.

 Re-insert the SD card or use M21 to enable the SD card following M22.
 */

 Usage
		 M22
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M23-Select SD file
		 sdcard Select an SD file to be executed SDSUPPORT
		 Usage
		 M23
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M24-Start or Resume SD print
		 sdcard Start or resume a file selected with `M23` SDSUPPORT
		 Start an SD print or resume the paused SD print.If PARK_HEAD_ON_PAUSE is enabled,unpark the nozzle.

		 Usage
		 M24
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M25-Pause SD print
		 sdcard Pause printing from the SD card SDSUPPORT
		 Pause the SD print in progress.If PARK_HEAD_ON_PAUSE is enabled,park the nozzle.

		 Usage
		 M25
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M26-Set SD position
		 sdcard Set the SD read position SDSUPPORT
		 Set the next read position in the open SD file.

		 Usage
		 M26
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M27-Report SD print status
		 sdcard Print SD progress to serial SDSUPPORT
		 Report the current SD read position in the form “SD printing byte 123/12345”.

		 Usage
		 M27
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M28-Start SD write
		 sdcard Start writing to a file on the SD card SDSUPPORT
		 This command starts a file write.All commands received by Marlin are written to the file and are not executed until M29 closes the file.

		 Usage
		 M28
		 Notes
		 Requires SDSUPPORT

		 To write commands to a file while also printing,use M928

		 thinkyhead
		 M29-Stop SD write
		 sdcard Stop writing the file,end logging.SDSUPPORT
		 Stop writing to a file that was begun with M28 or M928.Logging is disabled.

		 Usage
		 M29
		 Notes
		 Requires SDSUPPORT

		 thinkyhead
		 M30-Delete SD file
		 sdcard Delete a specified file from SD.
		 Usage
		 M30
		 Notes
		 Requires SDSUPPORT

		 Example
		 Delete the file “/path/to/file.gco”

		 M30/path/to/file.gco
		 thinkyhead
		 M31-Print time
		 printjob Report the current print time.
		 This command reports the time elapsed since the start of the current print job to the host.When printing from SD card,the print job timer starts as soon as SD printing starts.

		 If PRINTJOB_TIMER_AUTOSTART is enabled then the first M109 or M190 command received from the host will also start the print job timer.

		 For manual control from the host,use M75,M76,and M77 to start,pause,and stop the print job timer.

		 Usage
		 M31
		 thinkyhead
		 M32-Select and Start
		 sdcard Begin an SD print from a file.SDSUPPORT
		 The M32 command exists to allow G-code to load other G-code files and run them as sub-programs.This can be useful to change the start/end gcode for a batch of files without having to edit them all.

		 For legacy reasons M32 uses ‘!’ (and ‘#’)to delimit the filepath parameter.The filepath must be the last parameter.

		 Usage
		 M32[P<flag>][S<filepos>]
		Argument Description
		[P<flag>]
		Sub-Program flag

		[S<filepos>]
		Starting file offset

		Notes
		Requires SDSUPPORT

		This is a seldom-used beta feature that needs more testing and use-cases.

		Examples
		Select and start a file at offset 5022.

		M32 S5022!/boats/sailboat.gco
		Select and start a file from within G-code.

		M32 P!/models/lgbust.gco#
		The # suffix is needed when using P to “stop buffer pre-reading” so no commands after M32 will go into the buffer until after it returns.

		thinkyhead
		M33-Get Long Path
		1.0.2sdcard Convert a short pathname to a long pathname.SDSUPPORT LONG_FILENAME_HOST_SUPPORT
		Usage
		M33 path
		Argument Description
		path
		DOS 8.3path to a file or folder

		Notes
		Requires SDSUPPORT and LONG_FILENAME_HOST_SUPPORT

		Examples
		Get the long path for a file

		M33 funstuff/mask.gco
		Output

		FunStuff/Mask.gcode
		thinkyhead
		M34-SDCard Sorting
		1.1.0sdcard Set SDCard file sorting options.SDSUPPORT SDCARD_SORT_ALPHA
		Marlin now contains support for SDCard alphabetical file sorting in the LCD menus.This feature uses free SRAM to create a sorting index for up to the first 256 files in the current folder,and(if you have lots of SRAM)can optionally cache file listings for a more responsive UI.Buffering only occurs during file browsing.Otherwise the SRAM is freed.

		Usage
		M34[F<-1|0|1>][S<bool>]
		Argument Description
		[F<-1|0|1>]
		Folder Sorting

		F-1:Folders before files
		F0:No folder sorting
		F1:Folders after files
		[S<bool>]
		Sorting on/off

		Notes
		Requires SDSUPPORT and SDCARD_SORT_ALPHA.

		thinkyhead
		M42-Set Pin State
		control Set an analog or digital pin to a specified state.
		For custom hardware not officially supported in Marlin,you can often just connect up an unused pin and use M42 to control it.

		Usage
		M42[P<int>]S<int>
		Argument Description
		[P<int>]
		A digital pin number(even for analog pins)to write to.(LED_PIN if omitted)

		S<int>
		The state to set.PWM-able pins may be set from 0-255.

		thinkyhead
		M43-Debug Pins
		debug Get information about pins.PINS_DEBUGGING
		When setting up or debugging a machine it’s useful to know how pins are assigned to functions by the firmware,and to be able to find pins for use with new functions.M43 provides these tools.M43 by itself reports all pin assignments.Use P to specify a single pin.Use W to watch the specified pin,or all pins.Use the E option to monitor endstops.

		The W watch mode option continues looping,blocking all further commands,until the board is reset.If EMERGENCY_PARSER is enabled,M108 may also be used to exit the watch loop without needing to reset the board.

		Usage
		M43[E<bool>][P<pin>][W<bool>]
		Argument Description
		[E<bool>]
		Watch endstops

		[P<pin>]
		Digital Pin Number

		[W<bool>]
		Watch pins

		Notes
		Requires PINS_DEBUGGING.This feature should be disabled for production use.

		Examples
		Get a report on all pins

		M43
		Watch pin 56 for changes

		M43 P56 W
		Start watching endstops

		M43 E
		thinkyhead
		M48-Probe Accuracy Test
		calibration Measure Z Probe repeatability.Z_MIN_PROBE_REPEATABILITY_TEST
		Probes come in many flavors and as such have varying levels of accuracy,reliability,and repeatability,depending on several factors.This command tests the probe for accuracy and produces a standard deviation based on two or more probes of the same XY position.

		Usage
		M48[E<engage>][L<legs>][P<count>][V<level>][X<pos>][Y<pos>]
		Argument Description
		[E<engage>]
		Engage for each probe

		[L<legs>]
		Number of legs to probe

		[P<count>]
		Number of probes to do

		[V<level>]
		Verbose Level

		[X<pos>]
		X Position

		[Y<pos>]
		Y Position

		Notes
		Requires Z_MIN_PROBE_REPEATABILITY_TEST.

		thinkyhead
		M75-Start Print Job
		printjob Start the print job timer.
		Start the print job timer.

		Usage
		M75
		Example
		Start the print job timer

		M75
		thinkyhead
		M76-Pause Print Job
		printjob Pause the print job timer.
		Pause the print job timer.

		Usage
		M76
		Example
		Pause the print job timer

		M76
		thinkyhead
		M77-Stop Print Job
		printjob Stop the print job timer.
		Stop the print job timer.

		Usage
		M77
		Example
		Stop the print job timer

		M77
		thinkyhead
		M78-Print Job Stats
		printjob Print statistics about print jobs.PRINTCOUNTER
		Usage
		M78
		thinkyhead
		M80-Power On
		control Turn on the power supply.POWER_SUPPLY>0
		Turn on the high-voltage power supply.Requires a board that’s powered from USB or another 5 V source.

		Usage
		M80[S]
		Argument Description
		[S]
		Report Power Supply state

		Notes
		Requires POWER_SUPPLY and a digital pin connected to the PSU’s enable pin.

		thinkyhead
		M81-Power Off
		control Turn off the power supply.POWER_SUPPLY>0
		Turn off the high-voltage power supply.If the board is not powered from another source,this may also shut down the electronics.

		Usage
		M81
		Notes
		Requires POWER_SUPPLY and a digital pin connected to the PSU’s enable pin.

		thinkyhead
		M82-E Absolute
		units Set E to absolute positioning.
		This command is used to override G91 and put the E axis into absolute mode independent of the other axes.

		Usage
		M82
		thinkyhead
		M83-E Relative
		units Set E to relative positioning.
		This command is used to override G90 and put the E axis into relative mode independent of the other axes.

		Usage
		M83
		thinkyhead
		M85-Inactivity Shutdown
		control Set the inactivity timeout.
		Use this command to set a maximum period of time for the machine to be inactive(with no moves).If the machine is idle for longer than the set period,the firmware will shut everything down and halt the machine.

		Usage
		M85 S<seconds>
 Argument Description
		 S<seconds>
 Max inactive seconds

		 thinkyhead
		 M92-Set Axis Steps-per-unit
		 planner Set the number of steps-per-mm or steps-per-inch.
		 Use M92 to set the steps-per-unit for one or more axes.This setting affects how many steps will be done for each unit of movement.Units will be in steps/mm unless inch mode is set with G20(which requires INCH_MODE_SUPPORT).

		 Usage
		 M92[E<steps>][T<index>][X<steps>][Y<steps>][Z<steps>]
		Argument Description
		[E<steps>]
		E steps per unit

		[T<index>]
		Target extruder(Requires DISTINCT_E_FACTORS)

		[X<steps>]
		X steps per unit

		[Y<steps>]
		Y steps per unit

		[Z<steps>]
		Z steps per unit

		Notes
		Get the current steps-per-unit settings with M503.

		With EEPROM_SETTINGS enabled:

		This setting for all axes is saved with M500 and loaded with M501.
		M502 resets steps-per-unit for all axes to the values from DEFAULT_AXIS_STEPS_PER_UNIT.
		Example
		Set E steps for a new extruder

		M92 E688 .4
		thinkyhead
		M100-Free Memory
		debug Description Here M100_FREE_MEMORY_WATCHER
		Use M100 for development purposes to observe how much memory(particularly stack)is being used by code.Proper AVR code should avoid use of new,malloc,etc.,and instead use either pre-allocated static variables or stack.

		Usage
		M100[C<n>][D][F][I]
		Argument Description
		[C<n>]
		Corrupt ‘n’ locations in the free memory pool and report the locations of the corruption.This is useful to check the correctness of the M100 D and M100 F commands.

		[D]
		Dump the free memory block from __brkval to the stack pointer.

		[F]
		Return the number of free bytes in the memory pool along with other vital statistics that define the memory pool.

		[I]
		Initialize the free memory pool so it can be watched and print vital statistics that define the free memory pool.

		Notes
		Requires M100_FREE_MEMORY_WATCHER.

		thinkyhead
		M104-Set Hotend Temperature
		thermal Set a new target hot end temperature.
		Set a new target hot end temperature and continue without waiting.The firmware will continue to try to reach and hold the temperature in the background.

		Use M109 to wait for the hot end to reach the target temperature.

		Usage
		M104[B<temp>][F<flag>][S<temp>]
		Argument Description
		[B<temp>]
		AUTOTEMP:The max auto-temperature.

		[F<flag>]
		AUTOTEMP:Autotemp flag.Omit to disable autotemp.

		[S<temp>]
		Target temperature.
		AUTOTEMP:the min auto-temperature.

		Notes
		With PRINTJOB_TIMER_AUTOSTART this command will stop the print job timer if the temperature is set at or below half of EXTRUDE_MINTEMP.
		Examples
		Simple set target temperature

		M104 S180
		AUTOTEMP:Set autotemp range

		M104 F S180 B190
		AUTOTEMP:Disable autotemp

		M104
		thinkyhead
		M105-Report Temperatures
		thermal Send a temperature report to the host.
		Request a temperature report to be sent to the host at some point in the future.

		Usage
		M105[T<index>]
		Argument Description
		[T<index>]
		Hotend index

		Notes
		Some hosts may hide the reply from M105.

		A better way for hosts to get regular temperature updates is to use M155(requires AUTO_REPORT_TEMPERATURES and EXTENDED_CAPABILITIES_REPORT).Hosts then no longer need to run an extra process or use up slots in the command buffer to receive temperatures.

		Examples
		Get a temperature report

		M105
		thinkyhead
		M106-Set Fan Speed
		thermal Turn on the fan and set its speed
		Turn on one of the fans and set its speed.If no fan index is given,the print cooling fan.

		Usage
		M106[P<index>][S<speed>]
		Argument Description
		[P<index>]
		Fan index

		[S<speed>]
		Speed

		Notes
		M106 with no speed sets the fan to full speed.

		Turn off fans with M107.

		thinkyhead
		M107-Fan Off
		thermal Turn off a fan
		Turn off one of the fans.If no fan index is given,the print cooling fan.

		Usage
		M107[P<index>]
		Argument Description
		[P<index>]
		Fan index

		Notes
		Turn on fans with M106.

		thinkyhead
		M108-Break and Continue
		control Break out of the current waiting loop
		The M108 command requires EMERGENCY_PARSER for full effectiveness.(Otherwise a full queue blocks the parser.)

		Some G-code commands cause Marlin to go into a closed loop,waiting indefinitely for a certain state or event.For example,M109 waits for the target temperature to be reached,and M0 waits for an LCD click.

		In the case of M109,the M108 command stops waiting for the target temperature and continues processing G-code.This may result in “cold extrude” messages.For a full stop use M112.
		In the case of M0 the M108 command acts like the LCD button,breaking out of M0 and continuing to process the G-code queue.
		Usage
		M108
		Notes
		With both EMERGENCY_PARSER and HOST_KEEPALIVE_FEATURE enabled,hosts will be able to prompt for continuation or cancellation,confirming with M108 and cancelling with M112.

		Example
		Use M108 as a “Continue” button in your host software.

		M0 You're up, mate ; in your G-code file
		M108;as your"Continue"button
		thinkyhead
		M109-Wait for Hotend Temperature
		thermal Wait for the hot end to reach its target.
		This command optionally sets a new target hot end temperature and waits for the target temperature to be reached before proceeding.If the temperature is set with S then M109 waits only when heating.If the temperature is set with R then M109 will also wait for the temperature to go down.

		Usage
		M109[B<temp>][F<flag>][R<temp>][S<temp>]
		Argument Description
		[B<temp>]
		With AUTOTEMP,the max auto-temperature.

		[F<flag>]
		Autotemp flag.Omit to disable autotemp.

		[R<temp>]
		Target temperature(wait for cooling or heating).

		[S<temp>]
		Target temperature(wait only when heating).Also AUTOTEMP:The min auto-temperature.

		Notes
		With PRINTJOB_TIMER_AUTOSTART this command will start the print job if heating,and stop the print job timer if the temperature is set at or below half of EXTRUDE_MINTEMP.

		This command(and M190)can block new commands from the host,preventing remote shutdown.However,if EMERGENCY_PARSER is enabled,a host can send M108 to break out of the wait loop.

		To set the hot end temperature and proceed without waiting,use M104.

		Examples
		Set target temperature and wait(if heating)

		M109 S180
		Set target temperature,wait even if cooling

		M109 R120
		AUTOTEMP:Set autotemp range,wait for temp

		M109 F S180 B190
		AUTOTEMP:Disable autotemp,wait for temp

		M109
		thinkyhead
		M110-Set Line Number
		hosts Set the current line number.
		Hosts can use M110 to set the current line number in a print job.Each line number sent by a host must be one higher than the previous line number,or the firmware will ignore the line and send an error requesting a resend of the missing line.This is one technique Marlin uses to keep in sync with hosts.

		Usage
		M110 N<line>
 Argument Description
		 N<line>
 Line number

		 Notes
		 All these are valid:N100 M110,M110 N100,N101 M110 N100.

		 thinkyhead
		 M111-Debug Level
		 hosts Report and optionally set the debug flags.
		 Marlin has several debug bits that can be set,in combination,to help configure,troubleshoot,and debug the firmware.Add up the debug bits you need:

		 Mask Name Description
		 1 ECHO Echo all commands sent to the parser.
		 2 INFO Print extra informational messages.
		 4 ERRORS Print extra error messages.
		 8 DRYRUN Don’t extrude,don’t save leveling data,etc.
		 16 COMMUNICATION Not currently used.
		 32 LEVELING Detailed messages for homing,probing,and leveling.(Requires DEBUG_LEVELING_FEATURE.)
		 64 Reserved Reserved for future usage
		 128 Reserved Reserved for future usage
		 Usage
		 M111[S<flags>]
		Argument Description
		[S<flags>]
		Debug flag bits

		Examples
		Enable extra messages

		M111 S38;LEVELING,ERRORS,INFO
		Enable dry-run mode

		M111 S8
		Enable everything except dry-run mode

		M111 S247;255-8
		thinkyhead
		M112-Emergency Stop
		safety Shut everything down and halt the machine.
		Used for emergency stopping,M112 shuts down the machine,turns off all the steppers and heaters,and if possible,turns off the power supply.A reset is required to return to operational mode.

		Usage
		M112
		Notes
		M112 is the fastest way to shut down the machine using a host,but it may need to wait for a space to open up in the command queue.Enable EMERGENCY_PARSER for an instantaneous M112 command.

		Examples
		Shut down now!

		M112
		thinkyhead
		M113-Host Keepalive
		hosts Get or set the host keepalive interval.HOST_KEEPALIVE_FEATURE
		During some lengthy processes,such as G29,Marlin may appear to the host to have “gone away.” The “host keepalive” feature will send messages to the host when Marlin is busy or waiting for user response so the host won’t try to reconnect.

		Usage
		M113[S<seconds>]
		Argument Description
		[S<seconds>]
		Keepalive interval(0-60)

		Notes
		Requires HOST_KEEPALIVE_FEATURE.

		thinkyhead
		M114-Get Current Position
		hosts Report the current tool position to the host.
		Get the current position of the active nozzle.Includes stepper values.

		Usage
		M114
		Notes
		Hosts should respond to the output of M114 by updating their current position.

		Examples
		Get the current position

		M114
		thinkyhead
		M115-Firmware Info
		hosts Print the firmware info and capabilities.
		This command causes Marlin to output a string like this:

		FIRMWARE_NAME:Marlin 1.1.0(Github)SOURCE_CODE_URL:https://github.com/MarlinFirmware/Marlin PROTOCOL_VERSION:1.0 MACHINE_TYPE:RepRap EXTRUDER_COUNT:1 UUID:cede2a2f-41a2-4748-9b12-c55c62f367ff
		When EXTENDED_CAPABILITIES_REPORT is enabled,Marlin also reports its capabilities:

		Cap:EEPROM:1
		Cap:AUTOREPORT_TEMP:1
		Cap:PROGRESS:0
		Cap:AUTOLEVEL:1
		Cap:Z_PROBE:1
		Cap:SOFTWARE_POWER:0
		Cap:TOGGLE_LIGHTS:0
		Cap:EMERGENCY_PARSER:1
		Hosts use this information to improve interoperability,so it’s a good feature to enable.

		Usage
		M115
		thinkyhead
		M117-Set LCD Message
		lcd Set the message line on the LCD.ULTRA_LCD
		Set the status line message on the LCD.

		Usage
		M117[string]
		Argument Description
		[string]
		LCD status message

		Notes
		Requires an LCD controller.

		The message should appear immediately,but it will depend on LCD settings.

		Examples
		Set the message to “Yello World!”

		M117 Yello World!
		thinkyhead
		M119-Endstop States
		debug Report endstop and probe states to the host.
		Use this command to get the current state of all endstops,useful for setup and troubleshooting.Endstops are reported as either “open” or “TRIGGERED”.

		The state of the Z probe is also reported.

		Usage
		M119
		Examples
		Get all endstop states

		M119
		thinkyhead
		M120-Enable Endstops
		control Enable endstops and keep them enabled when not homing.
		Enable endstops.

		Usage
		M120
		Notes
		After this command endstops will be kept enabled when not homing.This may have side-effects if using ABORT_ON_ENDSTOP_HIT_FEATURE_ENABLED.

		Examples
		Enable endstops

		M120
		thinkyhead
		M121-Disable Endstops
		control Disable endstops and keep them enabled when not homing.
		Disable endstops.

		Usage
		M121
		Notes
		After this command endstops will be kept disabled when not homing.This may have side-effects if using ABORT_ON_ENDSTOP_HIT_FEATURE_ENABLED.

		Examples
		Disable endstops

		M121
		thinkyhead
		M125-Park Head
		nozzle Save current position and move to filament change position.PARK_HEAD_ON_PAUSE
		Save the current nozzle position and move to the configured park position.

		Usage
		M125[L<linear>][X<linear>][Y<linear>][Z<linear>]
		Argument Description
		[L<linear>]
		Retract length(otherwise FILAMENT_CHANGE_RETRACT_LENGTH)

		[X<linear>]
		X position to park at(otherwise FILAMENT_CHANGE_X_POS)

		[Y<linear>]
		Y position to park at(otherwise FILAMENT_CHANGE_Y_POS)

		[Z<linear>]
		Z raise before park(otherwise FILAMENT_CHANGE_Z_ADD)

		Notes
		Requires PARK_HEAD_ON_PAUSE.

		Examples
		Retract 2 cm of filament and park the nozzle

		M125 L20;park and retract
		*/

public interface PrinterCommand {
	String getCommandString();
}
