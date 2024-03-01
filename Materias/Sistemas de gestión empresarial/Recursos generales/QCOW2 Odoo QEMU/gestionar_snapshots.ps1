# Listar los snapshots
qemu-img snapshot -l debian-odoo-comprimido.qcow2

# # Crear un snapshot
# qemu-img snapshot -c "my-snapshot" debian-odoo-comprimido.qcow2

# # Restaurar un snapshot
# qemu-img snapshot -a "my-snapshot" debian-odoo-comprimido.qcow2

# # Borrar un snapshot
# qemu-img snapshot -d "my-snapshot" debian-odoo-comprimido.qcow2