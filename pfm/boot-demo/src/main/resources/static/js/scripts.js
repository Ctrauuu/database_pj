document.getElementById('user-form').addEventListener('submit', function(e) {
    e.preventDefault();

    const userId = document.getElementById('user-id').value;
    const name = document.getElementById('name').value;
    const password = document.getElementById('password').value;
    const gender = document.getElementById('gender').value;
    const occupation = document.getElementById('occupation').value;
    const email = document.getElementById('email').value;

    if (name && password && gender && occupation && email) {
        if (userId) {
            // Modify existing user
            const row = document.querySelector(`[data-id="${userId}"]`);
            row.children[0].textContent = name;
            row.children[1].textContent = password;
            row.children[2].textContent = gender;
            row.children[3].textContent = occupation;
            row.children[4].textContent = email;
        } else {
            // Add new user
            const tableBody = document.getElementById('users-table').querySelector('tbody');
            const newRow = tableBody.insertRow();

            newRow.setAttribute('data-id', Date.now());
            newRow.insertCell(0).textContent = name;
            newRow.insertCell(1).textContent = password;
            newRow.insertCell(2).textContent = gender;
            newRow.insertCell(3).textContent = occupation;
            newRow.insertCell(4).textContent = email;

            const actionsCell = newRow.insertCell(5);
            actionsCell.classList.add('actions');

            const editButton = document.createElement('button');
            editButton.classList.add('edit');
            editButton.textContent = 'Edit';
            editButton.addEventListener('click', () => editUser(newRow));
            actionsCell.appendChild(editButton);

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete');
            deleteButton.textContent = 'Delete';
            deleteButton.addEventListener('click', () => deleteUser(newRow));
            actionsCell.appendChild(deleteButton);
        }

        document.getElementById('user-form').reset();
        document.getElementById('user-id').value = '';
    }
});

function editUser(row) {
    document.getElementById('user-id').value = row.getAttribute('data-id');
    document.getElementById('name').value = row.children[0].textContent;
    document.getElementById('password').value = row.children[1].textContent;
    document.getElementById('gender').value = row.children[2].textContent;
    document.getElementById('occupation').value = row.children[3].textContent;
    document.getElementById('email').value = row.children[4].textContent;
}

function deleteUser(row) {
    row.remove();
}