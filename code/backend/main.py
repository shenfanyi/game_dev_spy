from flaskr import create_app

# Main Entry
if __name__ == '__main__':
    app = create_app()
    app.run(host='0.0.0.0', port=80)

