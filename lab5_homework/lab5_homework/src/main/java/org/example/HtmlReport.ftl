<!DOCTYPE html>
<html>
<head>
    <title>Catalog Report</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {background-color:#f5f5f5;}
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<h1>Catalog Report</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>TITLE</th>
        <th>LOCATION</th>
    </tr>
    </thead>
    <tbody>
    <#list documents as document>
    <tr>
        <td>${document.id}</td>
        <td>${document.title}</td>
        <td>${document.location}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>











