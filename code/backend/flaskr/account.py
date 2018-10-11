import functools
import uuid

from flask import (
    current_app,
    Blueprint,
    make_response,
    jsonify,
    request,
    abort,
    g
)

bp = Blueprint('account', __name__, url_prefix='/account')

# Generate a UUID for a device
@bp.route('/register', methods=['GET'])
def register():
    uid = uuid.uuid4()
    return jsonify(data={ 'uid': uid }, code=0)

# verify that a user is store in our database
@bp.route('/verify', methods=['GET'])
def verify():
    user_id = request.headers.get('token')
    # in case there is no user_id
    if user_id == None:
        abort(401)
    user_id = str(user_id)

    current_app.logger.info('id -> {}'.format(user_id))
    response = make_response('ok')
    response.headers.set('Content-Type', 'test/plain; charset=utf-8')
    return response




