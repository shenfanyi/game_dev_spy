import functools
import uuid

from flask import (
    Blueprint, g, jsonify, request, session, url_for
)

bp = Blueprint('account', __name__, url_prefix='/account')


# Generate a UUID for a device
@bp.route('/register', methods=['GET'])
def register():
    uid = uuid.uuid4()
    return jsonify(uid=uid, code=0)


