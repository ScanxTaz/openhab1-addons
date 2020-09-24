# Wake-on-LAN Binding

The Wake-on-LAN binding allows you to turn on or wake up a computer by sending it a [network message](https://en.wikipedia.org/wiki/Wake-on-LAN).

## Prerequisites

For Windows computers not in a domain, the firewall must be configured properly (allow remote shutdowns) and the DWORD-Regkey `LocalAccountTokenFilterPolicy` in `HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\System` must be set to 1.

## Binding Configuration

The Wake-on-LAN binding does not have a configuration file.

## Item Configuration

The syntax for the Wake-on-LAN binding configuration string is explained here:

```
wol="<broadcast-IP>#<macaddress>"
```

NOTE: The `<broadcast-IP>` address is the address of the subnet (usually --and depending your need-- take your IP,remove the digit after the last point and replace by 255. 
E.g : If your IP is 192.168.0.12, your subnet mask would certainly be 192.168.0.255). This is NOT the IP of the machine you want to wake up.

`<macaddress`> is the mac adress of the machine's network card you want to wakeup.

Here some examples for a typical C class network: - 192.168.1.255 for the destination IP 192.168.1.10 - or 127.0.0.255 for 127.0.0.15. 

Here are some examples of valid binding configuration strings:

```
wol="192.168.1.255#00:1f:d0:93:f8:b7"
wol="192.168.1.255#00-1f-d0-93-f8-b7"
```

As a result, your lines in the items file might look like the following:

```
Switch Network_OpenhabWebsite   "openHAB Web"   (Status, Network)   { wol="192.168.1.255#00:1f:d0:93:f8:b7" }
```

## Examples

The item binding can be combined with an exec binding to be able to switch the system on and off. The example below works if openHAB is running on a windows host.

```
Switch networkPC "Computer" (network, gOGBuero) { wol="192.168.10.255#00-DE-AD-BE-EF-00", exec=">[OFF:shutdown -s -m \\\\192.168.10.23 -t 0 -f]" }
```

The example below is for openHab running on a linux host.

```
Switch networkPC "Computer" (network, gOGBuero) { wol="192.168.10.255#00-DE-AD-BE-EF-00", exec=">[OFF:net rpc shutdown -C MESSAGE -I 192.168.10.23 -U USER%%PASSWORD -f -t 120]" }
```

