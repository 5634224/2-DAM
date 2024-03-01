# Path to disk file
$DISK_FILE = "debian-odoo-comprimido.qcow2"

# Paths to ISO CD-ROM files
$ISO_SO = "D:\Sistemas operativos\debian-12.4.0-amd64-netinst.iso"

# Create a 30 GB VirtIO disk if it does not exist
if (!(Test-Path $DISK_FILE)) {
  <# Action to perform if the condition is true #>
  qemu-img create -f qcow2 $DISK_FILE 30G
}

# Puertos de red de localhost que apuntarán a la máquina virtual
$PUERTO_80_PGADMIN = 8080
$PUERTO_8069_ODOO = 8069
$PUERTO_22_SSH = 2222

# Ejecución de la máquina virtual
& qemu-system-x86_64 `
  -enable-kvm `
  -m 1024 `
  -cpu kvm64,+ssse3,+sse4.1,+sse4.2,+popcnt,+avx2,hv-passthrough,hv-relaxed,hv-time,hv-vapic,hv-evmcs,hv-no-nonarch-coresharing=auto `
  -smp 4,sockets=1,cores=4,threads=1 `
  -machine type=q35,accel=whpx:tcg,kernel-irqchip=off `
  -rtc base=localtime `
  -drive file="$DISK_FILE",if=virtio `
  -boot order=cd,menu=on `
  -net nic,model=virtio -net user,hostfwd=tcp::$PUERTO_22_SSH-:22,hostfwd=tcp::$PUERTO_80_PGADMIN-:80,hostfwd=tcp::$PUERTO_8069_ODOO-:8069 `
  -monitor stdio `
  -device qxl-vga `
  -display none `
#   -display gtk,show-cursor=on,zoom-to-fit=on ` -> for installation of OS and SSH Server. After that, you can put -display none
#   -drive file="$ISO_SO",media=cdrom ` -> ISO file to install OS

# Crea un snapshot automático tras apagar la máquina virtual
# Get the current date and time
$dateTime = Get-Date -Format "yyyyMMdd-HHmmss"
# Create the snapshot name
$snapshotName = "Snapshot_$dateTime"

# Create the snapshot
qemu-img snapshot -c $snapshotName "$DISK_FILE"